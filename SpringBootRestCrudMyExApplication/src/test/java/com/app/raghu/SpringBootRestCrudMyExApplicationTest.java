package com.app.raghu;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.properties")
public class SpringBootRestCrudMyExApplicationTest {

	@Autowired
	private MockMvc mockMvc;

// 1. Test save Operations
//	@Test
//	@DisplayName("TESTING STUDENT SAVE OPERATIONS")
//	@Order(1)
//	public void testCreateStudent() throws Exception {
//
//		// 1. CREATE MOCKED REQUEST
//		MockHttpServletRequestBuilder request = 
//				MockMvcRequestBuilders.post("http://localhost:9691/v1/api/student/create")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{\n"
//						+ "    \"stdName\": \"Shivam\",\n"
//						+ "    \"stdGen\": \"Male\",\n"
//						+ "    \"stdMail\": \"alex@example.com\",\n"
//						+ "    \"stdCourse\": \"Java Full Stack\",\n"
//						+ "    \"stdAddress\": \"123 Main Street, Mumbai\"\n"
//						+ "}");
//		
//		// 2. EXECUTE IT AND READ RESULT (REQUEST + RESPONSE + EXCEPTION)
//		MvcResult result = mockMvc.perform(request).andReturn();
//		
//		// 3. READ RESPONSE FROM RESULT
//		MockHttpServletResponse response = result.getResponse();
//		
//		// 4. ASSERT RESULT
//		System.out.println("expected : "+ HttpStatus.CREATED.value() +" actual : " +response.getStatus());
//		
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//		
//		if(!response.getContentAsString().contentEquals("CREATED")) {
//			fail("STUDENT NOT CREATED");
//		}
//	}
		
		@Test
		@DisplayName("TESTING STUDENT SAVE OPERATIONS")
		@Order(1)
		public void testCreateStudentShort() throws Exception{
			mockMvc.perform(
						post("http://localhost:9690/v1/api/student/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content("    {\n"
								+ "        \"stdName\": \"Aniket\",\n"
								+ "        \"stdGen\": \"Male\",\n"
								+ "        \"stdMail\": \"alex@example.com\",\n"
								+ "        \"stdCourse\": \"Java Full Stack\",\n"
								+ "        \"stdAddress\": \"123 Main Street, Mumbai\"\n"
								+ "    }")
						).andExpect(
								status().isCreated()
								);
		}
		
		
		@Test
		@DisplayName("DELETE A STUDENT")
		@Order(2)
		public void deleteStudent() throws Exception{
			
			mockMvc.perform(
						delete("http://localhost:9691/v1/api/student/remove/22")
						.contentType(MediaType.APPLICATION_JSON)
					).andExpect(
							status().is2xxSuccessful()
			);
						
		}
		
		@Test
		@DisplayName("Modify a Student")
		@Order(3)
		public void updateStudent() throws Exception{
			
			mockMvc.perform(
						put("http://localhost:9691/v1/api/student/modify")
						.contentType(MediaType.APPLICATION_JSON)
						.content("    {\n"
								+ "    \"stdId\": 11,\n"
								+ "    \"stdName\": \"Amit\",\n"
								+ "    \"stdGen\": \"Male\",\n"
								+ "    \"stdMail\": \"alex@example.com\",\n"
								+ "    \"stdCourse\": \"Java Full Stack\",\n"
								+ "    \"stdAddress\": \"123 Main Street, Mumbai\"\n"
								+ "}")
						).andExpect(
								status().is2xxSuccessful()
					);
			
		}
		
		
		@Test
		@Order(4)
		@DisplayName("GET ONE STUDENT ")
		public void fetchOneTest() throws Exception{
			
			mockMvc.perform(

						get("http://localhost:9691/v1/api/student/fetch/8")
						.contentType(MediaType.APPLICATION_JSON)
		
					).andExpect(
							status().is2xxSuccessful()
			);
			
		}
		
		
		@Test
		@DisplayName("GET ALL STUDENT")
		@Order(5)
		public void fetchAllTest() throws Exception{
			
			mockMvc.perform(
						
						get("http://localhost:9691/v1/api/student/all")
						.contentType(MediaType.APPLICATION_JSON)
					
					).andExpect(
								status().is2xxSuccessful()
							
					);	
					
		}
		
	}

