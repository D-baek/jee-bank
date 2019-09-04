package com.bank.web.controllers;
import java.io.IOException;
import javax.servlet.ServletException;
import  javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import  com.bank.web.serviceimpls.MemberServiceImpl;
import  com.bank.web.service.MemberService;
@WebServlet("/member.do")
public class MemberController extends  HttpServlet {
   private static final long  serialVersionUID = 1L;
   protected void  doGet(HttpServletRequest request,  HttpServletResponse response)
          throws ServletException,  IOException {
      String action =  request.getParameter("action");
      System.out.println("액션 :  "+action);
      String dest =  request.getParameter("dest");
      System.out.println("목적지 :  "+dest);
      switch(action) {
      case "move":
          request.getRequestDispatcher
         (String.format(
        		 Constants.VIEW_PATH,
        		 "customer",
        		 request.getParameter("dest")))
          .forward(request, response);
          break;
      case "join":
          String id =  request.getParameter("id");
          String pw =  request.getParameter("pw");
          String name =  request.getParameter("name");
          String ssn =  request.getParameter("ssn");
          String credit =  request.getParameter("credit");
          CustomerBean param = new  CustomerBean();
          param.setCredit(credit);
          param.setId(id);
          param.setName(name);
          param.setPw(pw);
          param.setSsn(ssn);
          System.out.println("회원정보:  "+param.toString());
          MemberService service = new  MemberServiceImpl();
          service.join(param);
          request.getRequestDispatcher
          (String.format(
         		 Constants.VIEW_PATH,
         		 "customer",
         		 request.getParameter("dest")))
           .forward(request, response);
          break;
      case "login":break;
      }
   }
   protected void  doPost(HttpServletRequest request,  HttpServletResponse response)
          throws ServletException,  IOException {
      doGet(request, response);
   }
}
