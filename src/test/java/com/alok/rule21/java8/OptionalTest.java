package com.alok.rule21.java8;


import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Test;


public class OptionalTest {
	
	@Test
	public void whenCreatesEmptyOptionl_thenCorrect(){
		
		Optional<String> empty = Optional.empty();
		assertFalse(empty.isPresent());
	}

}
