package codeGenerater.code;

public class CodeGeneraterConstant {

	private static String txt = CodeGeneraterConstant.class.getClassLoader()
			.getResource("").toString()
			.replace("WebRoot/WEB-INF/classes", "src/codeGenerater/code/txt");
	//模板文件路径
	public static String txtPath = txt.substring(6, txt.length() - 1);
	
	private static String dao = CodeGeneraterConstant.class.getClassLoader()
			.getResource("").toString()
			.replace("WebRoot/WEB-INF/classes", "src/org/jsoft/dao");
	//dao层生成路径
	public static String daoPath = dao.substring(6, dao.length() - 1);
	
	private static String service = CodeGeneraterConstant.class
			.getClassLoader().getResource("").toString()
			.replace("WebRoot/WEB-INF/classes", "src/org/jsoft/service");
	//service层生成路径
	public static String servicePath = service.substring(6, service.length() - 1);
	
	private static String controller = CodeGeneraterConstant.class
			.getClassLoader().getResource("").toString()
			.replace("WebRoot/WEB-INF/classes", "src/org/jsoft/controller");
	//controller层生成路径
	public static String controllerPath = controller.substring(6, controller.length() - 1);
	
	private static String xml = CodeGeneraterConstant.class.getClassLoader()
			.getResource("").toString()
			.replace("WebRoot/WEB-INF/classes", "src/mybatis/jsoft");
	//mybatis配置文件和建表sql文件生成路径
	public static String xmlPath = xml.substring(6, xml.length() - 1);
	private static String sql = CodeGeneraterConstant.class.getClassLoader()
			.getResource("").toString()
			.replace("WebRoot/WEB-INF/classes", "src/mybatis/sql");
	public static String sqlPath = sql.substring(6, sql.length() - 1);
	
	public static final String CTRL_ORDINARY = "ORDINART";
	public static final String CTRL_DETAIL = "DETAIL";

}
