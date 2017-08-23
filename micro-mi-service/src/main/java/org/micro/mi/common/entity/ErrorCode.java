package org.micro.mi.common.entity;
/**
 * 公共返回错误码
 * @author pc
 *
 */
public class ErrorCode {

	public ErrorCode(){}
	public ErrorCode(Integer errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	//返回错误码
	private Integer errorCode;
	//返回错误信息
	private String errorMsg;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
