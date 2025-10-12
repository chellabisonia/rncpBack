package com.farukgenc.boilerplate.springboot.utils;

import java.util.Locale;

public final class ProjectConstants {

	// FIXME : Customize project constants for your application.

	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final Locale TURKISH_LOCALE = new Locale.Builder().setLanguage("en").setRegion("EN").build();

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
