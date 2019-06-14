package com.example.demo.test.data;

public class OnlineVo {

	private String deviceId;
	private String state;
	private Long timestamp;

	public OnlineVo(String deviceId, String state, Long timestamp) {
		this.deviceId = deviceId;
		this.state = state;
		this.timestamp = timestamp;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "OnlineVo [deviceId=" + deviceId + ", state=" + state + ", timestamp=" + timestamp + "]";
	}

	
}
