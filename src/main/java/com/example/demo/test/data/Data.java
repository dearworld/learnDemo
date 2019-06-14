package com.example.demo.test.data;

public class Data {

	private Integer fileType;
	private Object model;

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Data [fileType=" + fileType + ", model=" + model + "]";
	}

	
}
