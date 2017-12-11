package utils;

import java.util.List;
import java.util.Map;

public class BeanTool {

	@SuppressWarnings("rawtypes")
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			String str = (String) obj;
			if (str != null && !"".equals(str.trim())) {
				return false;
			} else {
				return true;
			}
		} else if (obj instanceof List) {
			List ls = (List) obj;
			if (ls != null && !ls.isEmpty()) {
				return false;
			} else {
				return true;
			}
		} else if (obj instanceof Map) {
			Map mp = (Map) obj;
			if (mp != null && !mp.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
}
