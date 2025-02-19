//package com.app.raghu.rest;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.fail;
//import static org.mockito.Mockito.mock;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@TestPropertySource("classpath:application.properties")
//public class StudentRestControllerTest {
//
////    @Autowired
//    private WebTestClient webTestClient;
//    
//    @BeforeEach
//    void setUp() {
//    	webTestClient = mock(WebTestClient.class);
//    }
//
//    @Test
//    @DisplayName("TESTING STUDENT SAVE OPERATION")
//    @Order(10)
//    public void testCreateStudent() {
//        // Perform the POST request and validate the response
//        webTestClient.post()
//                .uri("/v1/api/student/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue("{" +
//                        "\"stdName\": \"Amit\", " +
//                        "\"stdGen\": \"male\", " +
//                        "\"stdMail\": \"khatkale@gmail.com\", " +
//                        "\"stdCourse\": \"Information Engineering\", " +
//                        "\"stdAddress\": \"306, Sai Aaryan Building, Plot No 5, Panvel\"}")
//                .exchange()
//                .expectStatus().isEqualTo(HttpStatus.CREATED)
//                .expectBody(String.class)
//                .value(responseBody -> {
//                    assertNotNull(responseBody);
//                    if (!responseBody.contains("CREATED")) {
//                        fail("STUDENT NOT CREATED!!");
//                    }
//                });
//    }
//
//    @Test
//    @DisplayName("TESTING STUDENT SAVE OPERATION (SHORT VERSION)")
//    @Order(20)
//    public void testCreateShort() {
//        // Perform the POST request and validate the response (shortened form)
//        webTestClient.post()
//                .uri("/v1/api/student/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue("{" +
//                        "\"stdName\": \"Amit\", " +
//                        "\"stdGen\": \"male\", " +
//                        "\"stdMail\": \"khatkale@gmail.com\", " +
//                        "\"stdCourse\": \"Information Engineering\", " +
//                        "\"stdAddress\": \"306, Sai Aaryan Building, Plot No 5, Panvel\"}")
//                .exchange()
//                .expectStatus().isCreated();
//    }
//    
////    @Bean("webTestClient")
////    WebTestClient getClientBeans() {
////    	return mock(WebTestClient.class);
////    }
//}
