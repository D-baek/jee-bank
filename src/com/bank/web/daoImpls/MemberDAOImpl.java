package com.bank.web.daoImpls;
import com.bank.web.pool.Constants;
import java.io.File;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;

public class MemberDAOImpl implements MemberDAO{

	
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"member.txt");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		// TODO Auto-generated method stub
		return null;
	}
}
