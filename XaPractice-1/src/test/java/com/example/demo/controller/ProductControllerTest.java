package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IService service;

    private ProductEntity product;

    @BeforeEach
    void setUp() {
        product = new ProductEntity();
        product.setPid(1);
        product.setPname("Laptop");;
        product.setPmail("60005");
    }

    @Test
    void testSaveProduct() throws Exception {
        when(service.saveProduct(any(ProductEntity.class))).thenReturn(1);

        mockMvc.perform(post("/v1/api/pro/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().string("ProductEntity 1 saved Successfully"));
    }

    @Test
    void testGetOneProduct() throws Exception {
        when(service.getOneProduct(1)).thenReturn(product);

        mockMvc.perform(get("/v1/api/pro/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pid").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void testGetOneProduct_NotFound() throws Exception {
        when(service.getOneProduct(1)).thenThrow(new ProductNotFoundException("Product not found"));

        mockMvc.perform(get("/v1/api/pro/get/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testFetchAllProducts() throws Exception {
        List<ProductEntity> products = Arrays.asList(product);
        when(service.fetchAll()).thenReturn(products);

        mockMvc.perform(get("/v1/api/pro/fetchAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pid").value(1))
                .andExpect(jsonPath("$[0].name").value("Laptop"));
    }

    @Test
    void testDeleteProduct() throws Exception {
        doNothing().when(service).deleteProduct(1);

        mockMvc.perform(delete("/v1/api/pro/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("ProductEntity 1 REMOVED"));
    }

    @Test
    void testUpdateProduct() throws Exception {
        doNothing().when(service).updateProduct(any(ProductEntity.class));

        mockMvc.perform(put("/v1/api/pro/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().string("STDUENT 1 UPDATED"));
    }
}
