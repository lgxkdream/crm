package codeGenerater.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import codeGenerater.CGUtil;

public class CreateService {

	public static void createFile(String tableName){
		String[] tableArr = tableName.split("_");
		tableName = tableArr[0];
		for(int i = 1; i < tableArr.length; i++){
			tableName += CGUtil.upperFirst(tableArr[i]);
		}
		
		File incomingFile = new File(CodeGeneraterConstant.txtPath + "/IService.txt");
		File incomingImplFile = new File(CodeGeneraterConstant.txtPath + "/ServiceImpl.txt");
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		BufferedReader brImpl = null;
		BufferedWriter bwImpl = null;
		try {
			File outFile = new File(CodeGeneraterConstant.servicePath + "/I" + CGUtil.upperFirst(tableName) + "Service.java");
			File outImplFile = new File(CodeGeneraterConstant.servicePath + "/impl/" + CGUtil.upperFirst(tableName) + "ServiceImpl.java");
			
			br = new BufferedReader(new FileReader(incomingFile));
			bw = new BufferedWriter(new FileWriter(outFile));
			brImpl = new BufferedReader(new FileReader(incomingImplFile));
			bwImpl = new BufferedWriter(new FileWriter(outImplFile));
			
			String str = "";
			String fileStr = "";
			while ((str = br.readLine()) != null) {
				fileStr += str + "\n";
			}
			fileStr = fileStr.replace("{1}", CGUtil.upperFirst(tableName));
			fileStr = fileStr.replace("{2}", tableName);
			bw.write(fileStr);
			
			str = "";
			fileStr = "";
			
			while ((str = brImpl.readLine()) != null) {
				fileStr += str + "\n";
			}
			fileStr = fileStr.replace("{1}", CGUtil.upperFirst(tableName));
			fileStr = fileStr.replace("{2}", tableName);
			bwImpl.write(fileStr);
			
			
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
				if (bwImpl != null) {
					bwImpl.close();
				}
				if (brImpl != null) {
					brImpl.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
