package codeGenerater;

import java.util.HashMap;
import java.util.Map;

import codeGenerater.code.CodeGeneraterConstant;
import codeGenerater.code.CreateController;
import codeGenerater.code.CreateDao;
import codeGenerater.code.CreateService;
import codeGenerater.code.CreateXml;

public class CodeGenerater {

	/**
	 * tableName 表名，首字母小写，下划线分隔
	 * columnsMap 字段 key:字段名 value:字段类型
	 * type 代表controller生成类型，typeOrdinary为普通类型， typeDetail为详细类型
	 * 		建议用普通类型，默认不传
	 * @param args
	 */
	public static void main(String[] args) {
		String tableName = "customer";
		Map<String, String> columnsMap = new HashMap<String, String>();
		columnsMap.put("id", "varchar(32)");
		columnsMap.put("name", "varchar(32)");
		columnsMap.put("source", "varchar(32)");
		columnsMap.put("status", "varchar(32)");
		columnsMap.put("user_id", "varchar(32)");
		columnsMap.put("contact_time", "varchar(32)");
		columnsMap.put("time_of_contract", "varchar(32)");
		columnsMap.put("money", "varchar(32)");
		columnsMap.put("address", "varchar(32)");
		columnsMap.put("phone", "varchar(32)");
		columnsMap.put("remarks", "varchar(32)");
		String typeDetail = CodeGeneraterConstant.CTRL_DETAIL;
		create(tableName, columnsMap, typeDetail);
		System.out.println("生成成功，请刷新工程！");
	}
	
	public static void create(String tableName, Map<String, String> columnsMap, String type){
		CreateXml.createFile(tableName, columnsMap);
		CreateDao.createFile(tableName);
		CreateService.createFile(tableName);
		CreateController.createFile(tableName);
	}
	
}
