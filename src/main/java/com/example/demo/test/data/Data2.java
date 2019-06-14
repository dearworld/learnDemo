package com.example.demo.test.data;

public class Data2 {
	private Integer fileType;
	private OnlineVo OnlineVo;
	public Integer getFileType() {
		return fileType;
	}
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	public OnlineVo getOnlineVo() {
		return OnlineVo;
	}
	public void setOnlineVo(OnlineVo onlineVo) {
		OnlineVo = onlineVo;
	}
	@Override
	public String toString() {
		return "Data2 [fileType=" + fileType + ", OnlineVo=" + OnlineVo + "]";
	}

	
}
