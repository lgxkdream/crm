package codeGenerater;

public class CGUtil {

	public static String upperFirst(String str) {
		return str.substring(0, 1).toUpperCase() + str.replaceFirst("\\w", "");
	}

	public static String lowerFirst(String str) {
		return str.substring(0, 1).toLowerCase() + str.replaceFirst("\\w", "");
	}
}
