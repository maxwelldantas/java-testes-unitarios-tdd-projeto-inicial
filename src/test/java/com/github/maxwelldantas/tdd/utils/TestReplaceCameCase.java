package com.github.maxwelldantas.tdd.utils;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGenerator;

/**
 *
 * Inspirado no código do site abaixo.
 *
 * @see <a href=
 *      "https://leeturner.me/posts/building-a-camel-case-junit5-displaynamegenerator/">
 *      Building a Camel Case @DisplayNameGenerator For JUnit 5 - Lee Turner
 *      </a>
 */
public class TestReplaceCameCase extends DisplayNameGenerator.Standard {

	@Override
	public String generateDisplayNameForClass(Class<?> testClass) {
		return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
	}

	@Override
	public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
		return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
	}

	@Override
	public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
		return this.replaceCapitals(testMethod.getName());
	}

	private String replaceCapitals(String name) {
		name = name.replaceAll("([A-Z])", " $1");
		name = name.replaceAll("([0-9]+)", " $1");
		return name;
	}
}
