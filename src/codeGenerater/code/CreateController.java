package codeGenerater.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import codeGenerater.CGUtil;

public class CreateController{

	public static void createFile(String tableName, String type) {
		String[] tableArr = tableName.split("_");
		tableName = tableArr[0];
		for(int i = 1; i < tableArr.length; i++){
			tableName += CGUtil.upperFirst(tableArr[i]);
		}
		File incomingFile = null;
		if(CodeGeneraterConstant.CTRL_DETAIL.equals(type)){
			incomingFile = new File(CodeGeneraterConstant.txtPath + "/Controller.txt");
		}else if(CodeGeneraterConstant.CTRL_ORDINARY.equals(type)){
			incomingFile = new File(CodeGeneraterConstant.txtPath + "/Controller_ordinary.txt");
		}
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File outFile = new File(CodeGeneraterConstant.controllerPath + "/" + CGUtil.upperFirst(tableName) + "Controller.java");
			br = new BufferedReader(new FileReader(incomingFile));
			bw = new BufferedWriter(new FileWriter(outFile));
			String str = "";
			String fileStr = "";
			while ((str = br.readLine()) != null) {
				fileStr += str + "\n";
			}
			fileStr = fileStr.replace("{1}", CGUtil.upperFirst(tableName));
			fileStr = fileStr.replace("{2}", tableName);
			bw.write(fileStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void createFile(String tableName) {
		String[] tableArr = tableName.split("_");
		tableName = tableArr[0];
		for(int i = 1; i < tableArr.length; i++){
			tableName += CGUtil.upperFirst(tableArr[i]);
		}
		File incomingFile = new File(CodeGeneraterConstant.txtPath + "/Controller_ordinary.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File outFile = new File(CodeGeneraterConstant.controllerPath + "/" + CGUtil.upperFirst(tableName) + "Controller.java");
			br = new BufferedReader(new FileReader(incomingFile));
			bw = new BufferedWriter(new FileWriter(outFile));
			String str = "";
			String fileStr = "";
			while ((str = br.readLine()) != null) {
				fileStr += str + "\n";
			}
			fileStr = fileStr.replace("{1}", CGUtil.upperFirst(tableName));
			fileStr = fileStr.replace("{2}", tableName);
			bw.write(fileStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
