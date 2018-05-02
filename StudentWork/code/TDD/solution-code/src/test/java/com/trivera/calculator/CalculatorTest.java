package com.trivera.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

public class CalculatorTest {

	Calculator calculator;
	
	@Before
	public void beforeEachTestCase() {
		calculator = new Calculator();
	}
	
	@After
	public void afterEachTestCase() {
		calculator = null;
	}
	
	@Test
	public void test_AddTwoPositiveNumbers() {
		
		int expected = 42;
		
		int actual = calculator.add(2, 40);
		
		assertThat( actual, is( equalTo( expected ) ) );
	}
	
	
	
	
	
	@Test
	public void test_AddTwoNegativeNumbers() {
		
		int expected = -42;
		
		int actual = calculator.add(-2, -40);
		
		assertThat( actual, is( equalTo( expected ) ) );
	}
	
	
	@Test
	public void test_SubstractTwoPositiveNumbers() {
		int expected = 42;
		
		int actual = calculator.substract(2, 44);
		
		assertThat( actual, is( equalTo( expected ) ) );
	}
	
	
	
	
	
	
	
	
	
	

	/*
	 * @Test public void test_Add_PositiveNumbers() { calculator = new Calculator();
	 * 
	 * int result = calculator.add(2, 42); int expected = 44;
	 * 
	 * // HAMCREST Matchers: assertThat(result, is(expected)); // FooBar
	 * 
	 * 
	 * // JUNIT Matchers Assert.assertEquals("2+42=44", 44, result);
	 * 
	 * assertEquals(44, result);
	 * 
	 * } // end addition
	 * 
	 * 
	 * 
	 * 
	 * @Test public void test_Subtract_PositiveNumbers() { calculator = new
	 * Calculator();
	 * 
	 * int result = calculator.subtract(2, 42); int expected = 40;
	 * 
	 * // A assertThat(result, is ( expected ) );
	 * 
	 * // B assertEquals(expected, result);
	 * 
	 * }
	 */

} // end class
