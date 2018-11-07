package com.trivera.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

public class CalculatorTest {

	
	// Want to create a Calc,.
    // Add, Sub, Mult, Div

    Calculator calculator = new Calculator();


    public void test__add_two_positive_numbers(){

        int expected = 42;

        int result = calculator.add(2, 40);

        assertEquals(expected, result);

    }
	

    public void test__substract_two_positive_numbers(){

        int expected = 42;

        int result = calculator.subtract(2, 44);

        assertEquals(expected, result);

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
