package com.dhn.demo;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateCsvFile {
	
	private String fileName;
	
	private String path;
	
	private String lineSeparator = "\r\n";
	
	private ResultSet data;
	
	
	
	public CreateCsvFile() {
		super();
	}



	public CreateCsvFile(String fileName, String path , ResultSet data) {
		super();
		this.fileName = fileName;
		this.path = path;
		this.data = data;
	}



	public CreateCsvFile(String fileName, String path, String lineSeparator, ResultSet data) {
		super();
		this.fileName = fileName;
		this.path = path;
		this.lineSeparator = lineSeparator;
		this.data = data;
	}



	public ResultSet getData() {
		return data;
	}



	public void setData(ResultSet data) {
		this.data = data;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getLineSeparator() {
		return lineSeparator;
	}



	public void setLineSeparator(String lineSeparator) {
		this.lineSeparator = lineSeparator;
	}

	public boolean writeFile(String path , String fileName, ResultSet data) throws NullPointerException {
		return writeFile(path,fileName,this.lineSeparator,data);
	}
	
	public boolean writeFile(String path , String fileName , String lineSeparator, ResultSet data) throws NullPointerException {
		this.fileName = fileName;
		this.path = path;
		this.lineSeparator = lineSeparator;
		this.data = data;
		if(this.fileName == null || this.fileName =="" || this.path == null) {
			throw new NullPointerException("文件名或文件生成路径不能为空");
		}
		return writeFile();
	}
	
	/**
	 * 生成csv文件
	 * @param
	 * @return
	 */
	protected boolean writeFile() {
		boolean flag = false ;
		if( !this.path.endsWith(File.separator)) {
			this.path = this.path+ File.separator;
		}
		
		//往csv写数据
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(this.path+this.fileName), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.DEFAULT_QUOTE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			writer.writeAll(data, true);
			writer.flush();
			flag = true;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer!=null){
					writer.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag ;
	}
	
}
