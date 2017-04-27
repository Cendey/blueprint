package com.mit.lab.norm;

public class Generic {
	private String source;

	public Generic(String message) {
		setSource(message);
	}

	public static String[] toSplit(String source, String regex) {
		if (source != null && source.trim().length() > 0) {
			return source.split(regex);
		}
		return null;
	}

	public static String replaceNoneCharater(String source, String regex) {
		String result = null;
		if (source != null) {
			result = source.replaceAll(regex, "");
		}
		return result;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
