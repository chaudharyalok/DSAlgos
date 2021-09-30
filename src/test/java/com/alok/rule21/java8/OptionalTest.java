package com.alok.rule21.java8;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void whenCreatesEmptyOptionl_thenCorrect() {
		Optional<String> empty = Optional.empty();
		assertFalse(empty.isPresent());
	}
	
	@Test
	public void whenCreatesOptional_thenCorrect() {
		String name = "alok";
		Optional<String> ops = Optional.of(name);
		assertTrue(ops.isPresent());
	}
	
	@Test(expected=NullPointerException.class)
	public void whenCreatesOptionlNull_thenCorrect() {
		String name = null;
		Optional.of(name);
	}
	
	@Test
	public void givenNonNull_whenCreatesNullable_thenCorrect() {
		String name = "alok";
		Optional<String> ops = Optional.ofNullable(name);
		assertTrue(ops.isPresent());
	}
	
	@Test
	public void givenNull_whenCreatesNullable_thenCorrect() {
		String name = null;
		Optional<String> empty = Optional.ofNullable(name);
		assertFalse(empty.isPresent());
	}
	
	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
		Optional<String> ops = Optional.of("alok");
		ops.ifPresent(name -> System.out.print(name.length()));
	}
	
	@Test
	public void whenOrElseWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("alok");
		assertEquals("alok",name);
	}
	
	@Test
	public void whenOrElseGetWorks_thenCorrect() {
		String nullName = null;
		// orElseGet takes supplier interface which is invoked & returns the value of invocation
		String name = Optional.ofNullable(nullName).orElseGet(() -> "alok");
		assertEquals("alok",name);
	}
	
	/**
	 * when the wrapped value is not present, then both orElse() and orElseGet()
	 * work exactly the same way
	 * But if value is present orElseGet doesn't call the m/d invocation.
	 * It saves lot of resources if there is a web service or db call in 
	 * supplier function, the cost becomes very obvious
	 */

	@Test(expected = IllegalArgumentException.class)
	public void whenOrElseThrowWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
	}
	
	
}
