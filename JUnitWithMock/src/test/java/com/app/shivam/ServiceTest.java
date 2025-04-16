package com.app.shivam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Activate Junit with mock
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	// 1. one dummy object is created using Mockito
	@Mock
	private Repository repository;

	// 2. it will find all dependencies and inject them (like autowired)
	@InjectMocks
	private Service service;

	@Test
	public void testSuccess() throws SQLException {

		// Dummy implement given using mocking
		try {
			when(repository.getData())
					.thenReturn(Arrays.asList("A", "B", "Raghu", "12345", "1234"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Hospital using JUnit
		List<String> actual = service.getDataByLen();
		assertNotNull(actual);
		assertEquals(3, actual.size());

	}
	
	@Test
	public void testException() {
		
		try {
			when(repository.getData())
				.thenThrow(new SQLException("Connection issue"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<String> actual = service.getDataByLen();
		assertNotNull(actual);
		assertEquals(0, actual.size());	
		
	}
	
}
