package com.cloud.util;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.HtmlEmail;

public class Tools {
	
	public static void main(String[] args) {
		System.out.println(isEmail("liyongitsina.com"));
	}
	public static boolean isEmail(String email) 
    { 
		 boolean tag = true;  
	        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
	        final Pattern pattern = Pattern.compile(pattern1);  
	        final Matcher mat = pattern.matcher(email);  
	        if (!mat.find()) {  
	            tag = false;  
	        }  
	        return tag;  
    }
	public static String getIpAddr(HttpServletRequest request) {
	       String ip = request.getHeader("x-forwarded-for");
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	          ip = request.getHeader("Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	          ip = request.getHeader("WL-Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	          ip = request.getRemoteAddr();
	       }
	       return ip;
	}
	public  void sendHtmlEmail(String url,String sendto) throws Exception{
		HtmlEmail email = new HtmlEmail();
		URL path=this.getClass().getClassLoader().getResource("email.properties");
		String hostname=PropertiesTool.readValue(path.getPath(), "HostName");
	    email.setHostName(hostname);   
	    String authenticationName=PropertiesTool.readValue(path.getPath(), "AuthenticationName");
	    String authenticationPassword=PropertiesTool.readValue(path.getPath(), "AuthenticationPassword");
	    email.setAuthentication(authenticationName, authenticationPassword);        
		email.addTo(sendto);
		email.setCharset("utf-8");
		email.setFrom(authenticationName);
		email.setSubject("主题：找回密码");
		 
		email.setHtmlMsg("<html>你的密码:"+url+"</html>");
		
		email.setTextMsg("来自："+url+"的");
		
		//set mail
		email.send();
	}
}
