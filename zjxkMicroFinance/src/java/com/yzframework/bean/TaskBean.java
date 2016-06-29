package com.yzframework.bean;


public class TaskBean implements java.io.Serializable {

	private static final long serialVersionUID = -1L;

	private String processId;
	private String processInstanceId;
	private String processName;
	private String taskId;
	private String taskName;
	private String createTime;
	private String completeTime;
	private String taskStatus;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getProcessInstanceId() {
    	return processInstanceId;
    }

	public void setProcessInstanceId(String processInstanceId) {
    	this.processInstanceId = processInstanceId;
    }
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCompleteTime() {
    	return completeTime;
    }

	public void setCompleteTime(String completeTime) {
    	this.completeTime = completeTime;
    }

	public String getTaskStatus() {
    	return taskStatus;
    }

	public void setTaskStatus(String taskStatus) {
    	this.taskStatus = taskStatus;
    }

}
