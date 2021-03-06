package com.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.dao.*;


public class DomitoryDel extends ActionSupport {

	/**
	 * 根据Domitory_ID删除DomitoryBean
	 */
	private static final long serialVersionUID = 1L;
	//下面是Action内用于封装用户请求参数的属性
	private String Domitory_ID ;
	public String getDomitory_ID() {
		return Domitory_ID;
	}

	public void setDomitory_ID(String userID) {
		Domitory_ID = userID;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		
		//删除
		new DomitoryDao().Delete("Domitory_ID="+Domitory_ID);
		    
		return SUCCESS;
		
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
