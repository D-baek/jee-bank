package com.bank.web.daoImpls;
import com.bank.web.pool.Constants;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;

public class MemberDAOImpl implements MemberDAO{
	File file = new File(Constants.FILE_PATH+"customer.txt");
	List<String> list = new ArrayList<>();
	
@Override
	public void insertCustomer(CustomerBean param) {
		try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				writer.write(param.getId()+","
						+ param.getPw()+","
						+ param.getName()+","
						+ param.getSsn()+","
						+ param.getCredit());
				writer.newLine();
				writer.flush();
				writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
	
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean cus = new CustomerBean();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String user = reader.readLine();
			reader.close();
			String[] val = user.split(",");
			cus.setId(val[0]);
			cus.setPw(val[1]);
			cus.setName(val[2]);
			cus.setSsn(val[3]);
			cus.setCredit(val[4]);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
}
