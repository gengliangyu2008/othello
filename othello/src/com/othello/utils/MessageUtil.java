package com.othello.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageUtil {

	public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("othello");
	
	public static String getMessage(String labelName) {
		return RESOURCE_BUNDLE.getString( labelName );
	}
	
	public static String getFormattedMessage(String labelName, Object...args) {

		String msg = getMessage(labelName);
		return MessageFormat.format(msg, args);
	}
}
