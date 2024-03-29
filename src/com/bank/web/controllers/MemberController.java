package com.bank.web.controllers;
import java.io.IOException;
import javax.servlet.ServletException;
import  javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import com.bank.web.command.Sender;
import com.bank.web.command.Receiver;
import  com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import  com.bank.web.serviceimpls.MemberServiceImpl;
import  com.bank.web.service.MemberService;


@WebServlet("/customer.do")  //=> 서블릿패스
public class MemberController extends  HttpServlet {
	   private static final long  serialVersionUID = 1L;
	   protected void  service(HttpServletRequest request,  HttpServletResponse response)
	          throws ServletException,  IOException {
	
		      Receiver.init(request);
		      Receiver.cmd.execute();
		      Sender.forward(request,  response);
   }
}
