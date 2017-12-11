package codeGenerater.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import codeGenerater.CGUtil;

public class CreateXml {

	public static void createFile(String tableName, String[] columnsNameArr, String[] columnsTypeArr) {
		String[] tableArr = tableName.split("_");
		String className = tableArr[0];
		for(int i = 1; i < tableArr.length; i++){
			className += CGUtil.upperFirst(tableArr[i]);
		}
		if(columnsNameArr.length != columnsTypeArr.length){
			System.out.println("字段和字段类型输入数量不同！");
			return;
		}
		File xmlFile = new File(CodeGeneraterConstant.txtPath + "/xml.txt");
		File sqlFile = new File(CodeGeneraterConstant.txtPath + "/sql.txt");
		BufferedReader brXml = null;
		BufferedWriter bwXml = null;
		BufferedReader brSql = null;
		BufferedWriter bwSql = null;
		try {
			File outXmlFile = new File(CodeGeneraterConstant.xmlPath + "/" + className + ".xml");
			File outSqlFile = new File(CodeGeneraterConstant.xmlPath + "/" + className + ".sql");
			brXml = new BufferedReader(new FileReader(xmlFile));
			bwXml = new BufferedWriter(new FileWriter(outXmlFile));
			brSql = new BufferedReader(new FileReader(sqlFile));
			bwSql = new BufferedWriter(new FileWriter(outSqlFile));
			String str = "";
			String fileStr = "";
			String sqlStr = "";
			while ((str = brXml.readLine()) != null) {
				fileStr += str + "\n";
			}
			str = "";
			while ((str = brSql.readLine()) != null) {
				sqlStr += str + "\n";
			}
			String columnsStr = " ";
			String columnsValue = " ";
			String columnsValueItem = " ";
			String updateIf = "";
			String listAllIf = "";
			String sql = "";
			for(int i = 0; i < columnsNameArr.length; i++){
				columnsStr += columnsNameArr[i] + ",";
				columnsValue += "#{" + columnsNameArr[i] + "},";
				columnsValueItem += "#{item." + columnsNameArr[i] + "},";
				updateIf += "<if test=\" " + columnsNameArr[i] + " != null \">" + "\n" + "\t\t\t\t" + columnsNameArr[i] + " = #{" + columnsNameArr[i] + "}," + "\n" + "\t\t\t</if>\n\t\t\t";
				listAllIf += "<if test=\" " + columnsNameArr[i] + " != null and " + columnsNameArr[i] + " != '' \">" + "\n" + "\t\t\t\tand " + columnsNameArr[i] + " = #{" + columnsNameArr[i] + "}" + "\n" + "\t\t\t</if>\n\t\t\t";
				if(i == 0){
					sql += "\t" + columnsNameArr[i] + " " + columnsTypeArr[i] + " NOT NULL,\n";
				}else{
					sql += "\t" + columnsNameArr[i] + " " + columnsTypeArr[i] + " default NULL,\n";
				}
			}
			columnsStr = columnsStr.substring(0, columnsStr.length() - 1).toUpperCase() + " ";
			columnsValue = columnsValue.substring(0, columnsValue.length() - 1) + " ";
			columnsValueItem = columnsValueItem.substring(0, columnsValueItem.length() - 1) + " ";
			fileStr = fileStr.replace("{1}", tableName);
			fileStr = fileStr.replace("{2}", columnsStr);
			fileStr = fileStr.replace("{3}", columnsValue);
			fileStr = fileStr.replace("{4}", columnsValueItem);
			fileStr = fileStr.replace("{5}", updateIf);
			fileStr = fileStr.replace("{6}", listAllIf);
			fileStr = fileStr.replace("{7}", className);
			sqlStr = sqlStr.replace("{1}", tableName);
			sqlStr = sqlStr.replace("{2}", sql);
			bwSql.write(sqlStr);
			bwXml.write(fileStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bwXml != null) {
					bwXml.close();
				}
				if (brXml != null) {
					brXml.close();
				}
				if (bwSql != null) {
					bwSql.close();
				}
				if (brSql != null) {
					brSql.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void createFile(String tableName, Map<String, String> columnsMap) {
		String[] tableArr = tableName.split("_");
		String className = tableArr[0];
		for(int i = 1; i < tableArr.length; i++){
			className += CGUtil.upperFirst(tableArr[i]);
		}
		if(columnsMap == null || columnsMap.size() <= 0){
			System.out.println("字段和字段类型输入不正确！");
			return;
		}
		File xmlFile = new File(CodeGeneraterConstant.txtPath + "/xml.txt");
		File sqlFile = new File(CodeGeneraterConstant.txtPath + "/sql.txt");
		BufferedReader brXml = null;
		BufferedWriter bwXml = null;
		BufferedReader brSql = null;
		BufferedWriter bwSql = null;
		try {
			File outXmlFile = new File(CodeGeneraterConstant.xmlPath + "/" + className + ".xml");
			File outSqlFile = new File(CodeGeneraterConstant.sqlPath + "/" + className + ".sql");
			brXml = new BufferedReader(new FileReader(xmlFile));
			bwXml = new BufferedWriter(new FileWriter(outXmlFile));
			brSql = new BufferedReader(new FileReader(sqlFile));
			bwSql = new BufferedWriter(new FileWriter(outSqlFile));
			String str = "";
			String fileStr = "";
			String sqlStr = "";
			while ((str = brXml.readLine()) != null) {
				fileStr += str + "\n";
			}
			str = "";
			while ((str = brSql.readLine()) != null) {
				sqlStr += str + "\n";
			}
			String columnsStr = " ";
			String columnsValue = " ";
			String columnsValueItem = " ";
			String updateIf = "";
			String listAllIf = "";
			String sql = "";
			Iterator<Entry<String, String>> it = columnsMap.entrySet().iterator();
			while(it.hasNext()){
				Entry<String, String> entry = it.next();
				String columnsName = entry.getKey();
				String columnsType = entry.getValue();
				columnsStr += columnsName + ",";
				columnsValue += "#{" + columnsName + "},";
				columnsValueItem += "#{item." + columnsName + "},";
				updateIf += "<if test=\" " + columnsName + " != null \">" + "\n" + "\t\t\t\t" + columnsName + " = #{" + columnsName + "}," + "\n" + "\t\t\t</if>\n\t\t\t";
				listAllIf += "<if test=\" " + columnsName + " != null and " + columnsName + " != '' \">" + "\n" + "\t\t\t\tand " + columnsName + " = #{" + columnsName + "}" + "\n" + "\t\t\t</if>\n\t\t\t";
				if("id".equals(columnsName)){
					sql += "\t" + columnsName + " " + columnsType + " NOT NULL,\n";
				}else{
					sql += "\t" + columnsName + " " + columnsType + " default NULL,\n";
				}
			}
			columnsStr = columnsStr.substring(0, columnsStr.length() - 1).toUpperCase() + " ";
			columnsValue = columnsValue.substring(0, columnsValue.length() - 1) + " ";
			columnsValueItem = columnsValueItem.substring(0, columnsValueItem.length() - 1) + " ";
			fileStr = fileStr.replace("{1}", tableName);
			fileStr = fileStr.replace("{2}", columnsStr);
			fileStr = fileStr.replace("{3}", columnsValue);
			fileStr = fileStr.replace("{4}", columnsValueItem);
			fileStr = fileStr.replace("{5}", updateIf);
			fileStr = fileStr.replace("{6}", listAllIf);
			fileStr = fileStr.replace("{7}", className);
			sqlStr = sqlStr.replace("{1}", tableName);
			sqlStr = sqlStr.replace("{2}", sql);
			bwSql.write(sqlStr);
			bwXml.write(fileStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bwXml != null) {
					bwXml.close();
				}
				if (brXml != null) {
					brXml.close();
				}
				if (bwSql != null) {
					bwSql.close();
				}
				if (brSql != null) {
					brSql.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
