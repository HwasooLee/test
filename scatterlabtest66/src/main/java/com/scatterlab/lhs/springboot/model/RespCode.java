package com.scatterlab.lhs.springboot.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Response")
public class RespCode {
    private long procCnt;
    private String respCode;
    private String respMsg;
	public long getProcCnt() {
		return procCnt;
	}
	public void setProcCnt(long procCnt) {
		this.procCnt = procCnt;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
    
    
}