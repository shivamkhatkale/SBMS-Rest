package com.example.demo.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.controller.Controller;
import com.example.demo.entity.ProductEntity;
import com.example.demo.serviceimpl.ProductImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductImpl service;

    @InjectMocks
    private Controller controller;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testCreateProduct() throws Exception {
        ProductEntity product = new ProductEntity(1, "Laptop", "New Laptop");

        mockMvc.perform(post("/v1/api/Student/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().string("Product 1 created"));

        verify(service, times(1)).createOneProduct(any(ProductEntity.class));
    }

    @Test
    void testFetchOneProduct() throws Exception {
        ProductEntity product = new ProductEntity(1, "Laptop", "New Laptop");
        when(service.getOneProduct(1)).thenReturn(product);

        mockMvc.perform(get("/v1/api/Student/fetch/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.message").value("New Laptop"));

        verify(service, times(1)).getOneProduct(1);
    }

    @Test
    void testFetchAllProducts() throws Exception {
        List<ProductEntity> products = Arrays.asList(
                new ProductEntity(1, "Laptop", "New Laptop"),
                new ProductEntity(2, "Mobile", "New Mobile")
        );
        when(service.getAllList()).thenReturn(products);

        mockMvc.perform(get("/v1/api/Student/fetch-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));

        verify(service, times(1)).getAllList();
    }

    @Test
    void testModifyProduct() throws Exception {
        ProductEntity updatedProduct = new ProductEntity(1, "Updated Laptop", "Updated Message");

        mockMvc.perform(put("/v1/api/Student/modify")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedProduct)))
                .andExpect(status().isOk())
                .andExpect(content().string("Product 1 Updated Successfully..."));

        verify(service, times(1)).updateProduct(any(ProductEntity.class));
    }

    @Test
    void testDeleteProduct() throws Exception {
        doNothing().when(service).deleteOneProduct(1);

        mockMvc.perform(delete("/v1/api/Student/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Product 1 Delete Successfully"));

        verify(service, times(1)).deleteOneProduct(1);
    }
}
