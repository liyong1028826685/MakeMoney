package com.cloud.bean;

public class User {
	private Integer id;
	private String user_name;
	private String user_pass;
	private Integer age;
	public Integer getAge() {
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String userPass) {
		user_pass = userPass;
	}
	
	
}
