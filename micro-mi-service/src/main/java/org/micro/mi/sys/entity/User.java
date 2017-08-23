package org.micro.mi.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * micro_mi's user entity
 * @author xifeng.liu
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7646567209278241883L;
	/*
	 * 主键id
	 */
	private String id;
	/*
	 * 注册用户名
	 */
	private String userName;
	/*
	 * 用户昵称
	 */
	private String nickName;
	/*
	 * 密码
	 */
	private String password;
	/*
	 * 用户最近的一次旧密码
	 */
	private String oldPassword;
	/*
	 * 用户类型
	 */
	private Integer userType;
	/*
	 * 性别
	 */
	private Integer sex;
	/*
	 * 用户状态
	 */
	private Integer status;
	/*
	 * 用户邮箱
	 */
	private String email;
	/*
	 * 是否可用 1 可用  0不可用
	 */
	private Integer isValid;
	/*
	 * 创建时间
	 */
	private Date createTime;
	/*
	 * 更新时间
	 */
	private Date updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
