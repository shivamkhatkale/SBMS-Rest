package com.app.shivam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.app.shivam.MathService;

public class MathServiceTest {

	MathService ms = null;
	int expected;
	int subexp;

	@BeforeEach
	public void setup() {
		ms = new MathService();
		expected = 30;
		subexp = 10;
	}

	@Test
	public void testAdd() {
		int actual = ms.add(10, 20);
		assertEquals(expected, actual);
		boolean result = ms.isEven(50);
		assertTrue(result);
	}

	@Test
	public void testSub() {
		int actual = ms.sub(20, 10);
		assertEquals(subexp, actual);
	}

	@AfterEach
	public void clean() {
		ms = null;
	}

}
