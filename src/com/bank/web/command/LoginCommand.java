package com.bank.web.command;
import javax.servlet.http.HttpServletRequest;
import com.bank.web.domains.CustomerBean;
import com.bank.web.service.MemberService;
import com.bank.web.serviceimpls.MemberServiceImpl;

public class LoginCommand extends MoveCommand{
	public LoginCommand(HttpServletRequest  request)throws Exception {
		super(request);
	}
	@Override
	public void execute() {
		super.execute();
		MemberService service = new MemberServiceImpl();
		CustomerBean param = new  CustomerBean();
        String id =  request.getParameter("id");
        String pw =  request.getParameter("pw");
		 id =  request.getParameter("id");
         pw =  request.getParameter("pw");
         param.setId(id);
         param.setPw(pw);
         System.out.printf("로그인  서비스 진입 후 아이디 %s , 비번 %s", id,  pw);
         CustomerBean cust =  service.login(param);
         String Page = "";
         System.out.println("로그인할 회원정보" + cust);
         if(cust == null) {
        	 page = "login";
         }else {
        	 page = "mypage";
            Receiver.cmd.setPage("mypage");
         }
         request.setAttribute( "customer",cust);
         Receiver.cmd.setPage(page);
         
	}
}
