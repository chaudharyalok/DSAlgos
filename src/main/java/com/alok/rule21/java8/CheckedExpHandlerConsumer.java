package com.alok.rule21.java8;

@FunctionalInterface
public interface CheckedExpHandlerConsumer<Target,ExpObj extends Exception> {

	void accept(Target target) throws ExpObj;
}
