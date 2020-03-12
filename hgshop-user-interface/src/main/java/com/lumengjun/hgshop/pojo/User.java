package com.lumengjun.hgshop.pojo;

import java.io.Serializable;
/**
 * 用户类
 * @author ASUS
 *
 */
public class User implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 2721298606891161223L;
//主键
  private Integer	uid        ;
  //账号
  private String	username   ;
  //密码
  private String	password   ;
  //名称
  private String	name       ;
  //邮箱
  private String	email      ;
  //电话号
  private String	telephone  ;
  //出生日期
  private String	birthday   ;
  //性别
  private String	sex        ;
  //状态
  private String	state      ;
  //
  private String	code       ;
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", username=" + username + ", password="
			+ password + ", name=" + name + ", email=" + email + ", telephone="
			+ telephone + ", birthday=" + birthday + ", sex=" + sex
			+ ", state=" + state + ", code=" + code + "]";
}
public User(Integer uid, String username, String password, String name,
		String email, String telephone, String birthday, String sex,
		String state, String code) {
	super();
	this.uid = uid;
	this.username = username;
	this.password = password;
	this.name = name;
	this.email = email;
	this.telephone = telephone;
	this.birthday = birthday;
	this.sex = sex;
	this.state = state;
	this.code = code;
}
public User() {
	super();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((uid == null) ? 0 : uid.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (uid == null) {
		if (other.uid != null)
			return false;
	} else if (!uid.equals(other.uid))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}

	

}
