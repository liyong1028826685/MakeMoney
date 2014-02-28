package com.cloud.action;

import org.apache.struts2.ServletActionContext;

import com.cloud.bean.User;
import com.cloud.service.UserService;
import com.cloud.util.DESUtil;

public class UserAction {
	private UserService userService;
	private User user=new User();
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//�û�ע��
	public String register(){
		String msg="ע��ʧ��!";
		User localuser=null;
		try {
			localuser=userService.getUserByName(user.getUser_name());
			if(localuser!=null){
				msg="�û����Ѵ���!";
			}else{
				
				user.setUser_pass(DESUtil.encrypt(user.getUser_pass()));
			
				msg="ע��ɹ�!";
				userService.save(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "result";
	}
	
}
