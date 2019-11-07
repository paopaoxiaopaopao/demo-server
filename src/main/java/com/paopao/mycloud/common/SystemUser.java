package com.paopao.mycloud.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统登录用户bean
 * 
 * @author pp
 *
 */
public class SystemUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String userName;

	private String email;

	private String gender;

	private String mobile;
	
    private Date createTime;//创建时间

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SystemUser [id=" + id + ", userName=" + userName + ", email=" + email + ", gender=" + gender
				+ ", mobile=" + mobile + ", createTime=" + createTime + "]";
	}
}
