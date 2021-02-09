package com.Task2.service;

import com.Task2.jdbcmodel.FirstModelForReport;
import com.Task2.jdbcmodel.TimeObject;
import com.Task2.model.ProductGroup;
import com.Task2.model.ProductGroups;
import com.Task2.repository.ProductGroupRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
@Transactional
public class ProductGroupService {
    private  final ProductGroupRepository productGroupRepository;
    private final JdbcTemplate jdbcTemplate;


    public ProductGroupService(ProductGroupRepository productGroupRepository, JdbcTemplate jdbcTemplate) {
        this.productGroupRepository = productGroupRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductGroup> getProductGroups() {
        return productGroupRepository.findAll();
    }

    public ProductGroup getProductGroup(Long id) {
        return productGroupRepository.findById(id).orElseThrow(null);
    }

    public ProductGroup newProductGroup(@RequestBody ProductGroup productGroup) {
        return productGroupRepository.save(productGroup);
    }

    public void deleteProductGroup(Long id) {
        productGroupRepository.deleteById(id);
    }

    public ProductGroup update(ProductGroup newProductGroup, Long id) {
        return productGroupRepository.findById(id).map(
                productGroup -> {
                    productGroup.setCode(newProductGroup.getCode());
                    productGroup.setName(newProductGroup.getName());
                    productGroup.setParent_id(newProductGroup.getParent_id());
                    productGroup.setProductsLists(newProductGroup.getProductsLists());
                    return productGroupRepository.save(productGroup);
                }
        ).orElseThrow(null);
    }

    public ProductGroup getStat(Long id) {
        RowMapper<ProductGroup> rm = (RowMapper<ProductGroup>) (ResultSet result, int rowNum) -> {

            ProductGroup pg = new ProductGroup();
            pg.setId(result.getLong("id"));
            pg.setCode(result.getLong("code"));
            pg.setName(result.getString("name"));
            pg.setParent_id(result.getLong("parent_id"));

            return pg;
        };
        return jdbcTemplate.queryForObject("select * from product_group where id = ?", new Object[]{id}, rm);
    }

    public List<FirstModelForReport> getTimeReport(TimeObject timeObject) {
        RowMapper<FirstModelForReport> rm = (ResultSet result, int rowNum) -> {
            FirstModelForReport fmfr = new FirstModelForReport();
            fmfr.setGroupName(result.getString("group_name"));
            fmfr.setProductName(result.getString("product_name"));
            fmfr.setAllPrihod(result.getInt("prihod"));
            fmfr.setPrihodTime(timeObject.getStartTime());
            fmfr.setAllRashod(result.getInt("rashod"));
            fmfr.setRashodDate(timeObject.getEndTime());

            return fmfr;
        };

        return jdbcTemplate.query(
                "SELECT product_group.name as group_name, p.name as product_name,  SUM(pr.num*pr.price) as prihod,  SUM(r.num*r.price) as rashod FROM product_group\n" +
                "    JOIN product p on product_group.id = p.group_id\n" +
                "    JOIN prihod pr on p.id = pr.prod_id\n" +
                "    JOIN rashod r on p.id = r.prod_id WHERE pr.time " +
                        "BETWEEN " + timeObject.getStartTime() + "  AND " + timeObject.getEndTime() + " " +
                        "AND " +
                        "r.time BETWEEN " + timeObject.getStartTime() +" AND " + timeObject.getEndTime() +
                "GROUP BY product_group.name, p.name", rm);
    }

    private static String jaxbObjectToXML(ProductGroups product)
    {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProductGroups.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();

            // To format XML
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(product, sw);

            return sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return "";
    }
}
