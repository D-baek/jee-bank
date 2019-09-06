package com.bank.web.controllers;
import java.io.IOException;
import javax.servlet.ServletException;
import  javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;

import com.bank.web.command.Carrier;
import com.bank.web.command.Receiver;
import  com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import  com.bank.web.serviceimpls.MemberServiceImpl;
import  com.bank.web.service.MemberService;
@WebServlet("/customer.do")  //=> 서블릿패스
public class MemberController extends  HttpServlet {
   private static final long  serialVersionUID = 1L;
   protected void  doGet(HttpServletRequest request,  HttpServletResponse response)
          throws ServletException,  IOException {
      
      CustomerBean param = new  CustomerBean();
      MemberService service = new  MemberServiceImpl();
      Receiver.init(request);
      Receiver.cmd.execute();
      if(Receiver.cmd.getAction()==null)  {
          Receiver.cmd.setPage();
      }
      
         switch(Receiver.cmd.getAction()) {
          case "join":
             String id =  request.getParameter("id");
             String pw =  request.getParameter("pw");
             String name =  request.getParameter("name");
             String ssn =  request.getParameter("ssn");
             String credit =  request.getParameter("credit");
             
             param.setCredit(credit);
             param.setId(id);
             param.setName(name);
             param.setPw(pw);
             param.setSsn(ssn);
             System.out.println("회원정보:  "+param.toString());
             service.join(param);
             Receiver.cmd.setPage("login");
             break;
          case "login":
             id =  request.getParameter("id");
             pw =  request.getParameter("pw");
             param.setId(id);
             param.setPw(pw);
             System.out.printf("로그인  서비스 진입 후 아이디 %s , 비번 %s", id,  pw);
             CustomerBean cust =  service.login(param);
             if(cust == null) {
                Receiver.cmd.setPage("login");
             }else {
                Receiver.cmd.setPage("mypage");
             }
             request.setAttribute(  "customer",cust);
             
             break;
          case "existId":
             break;
          }
      
      Sender.forward(request,  response);
   }
   protected void  doPost(HttpServletRequest request,  HttpServletResponse response)
          throws ServletException,  IOException {
      doGet(request, response);
   }
}