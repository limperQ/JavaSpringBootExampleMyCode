package com.Task2;

import com.Task2.jdbcmodel.FirstModelForReport;
import com.Task2.jdbcmodel.TimeObject;
import com.Task2.model.ProductGroup;
import com.Task2.model.ProductGroups;
import com.Task2.service.ProductGroupService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProductGroupController.ROOT)
public class ProductGroupController {
    public static final String ROOT = "/products";

    private final ProductGroupService productGroupService;

    public ProductGroupController(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @GetMapping
    public List<ProductGroup> getProductGroups() {
        return productGroupService.getProductGroups();
    }

    @GetMapping("/{id}")
    public ProductGroup getProductGroup(@PathVariable Long id) {
        return productGroupService.getProductGroup(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductGroup(@PathVariable Long id) {
        productGroupService.deleteProductGroup(id);
    }

    @PutMapping("/{id}")
    public ProductGroup updateAccount(@RequestBody ProductGroup newProductGroup, @PathVariable Long id) {
        return productGroupService.update(newProductGroup, id);
    }

    @PostMapping
    public ProductGroup newAccount(@RequestBody ProductGroup newProductGroup) {
        return productGroupService.newProductGroup(newProductGroup);
    }

    @GetMapping(value = "/getStat/{id}")
    public ProductGroup getStat(@PathVariable Long id) {
        return productGroupService.getStat(id);
    }


    @RequestMapping(value = "/getTimeReport", method = RequestMethod.POST)
    public List<FirstModelForReport> getTimeReport(@RequestBody TimeObject timeObject) {
        System.out.println(timeObject.getStartTime() + " " + timeObject.getEndTime());
        return productGroupService.getTimeReport(timeObject);
    }

    @GetMapping(value = "/getTest")
    public TimeObject getTestTimeObject() {
        return new TimeObject("2020-07-30", "2020-12-12");
    }
}
