package com.bank.web.serviceimpls;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.bank.web.domains.AccountBean;
import com.bank.web.service.AccountService;

public class AccountServiceImpl implements AccountService{
	private List<AccountBean> accounts;
	Random random;
	Date date;
	SimpleDateFormat sdf;
	
	public AccountServiceImpl() {
		accounts = new ArrayList<>();
	}
	
	public void createAccount(String money) {
		AccountBean acc = new AccountBean();
		acc.setMoney(String.valueOf(money));
		acc.setAccountNum(createAccountNum());
		acc.setRegDate(findDate());
		System.out.println(acc.toString());
		accounts.add(acc);
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		random = new Random();
		for(int i = 0; i < 9; i++) {
			accountNum += (i==4)? "-" :random.nextInt(10);
		}
		return accountNum;
	}

	@Override
	public List<AccountBean> findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean acc = new AccountBean();
		for(AccountBean a :accounts) {
			if(accountNum.equals(a.getAccountNum())) {
				acc = a;
			}
		}
		return acc;
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		AccountBean a = findByAccountNum(accountNum);
		return accounts.contains(a);
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		AccountBean a = findByAccountNum(param.getAccountNum());
		int budget = Integer.parseInt(a.getMoney()) + Integer.parseInt(param.getMoney());
		int idx = accounts.indexOf(a);
		accounts.get(idx).setMoney(String.valueOf(budget));
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		AccountBean a = findByAccountNum(param.getAccountNum());
		int budget = Integer.parseInt(a.getMoney()) - Integer.parseInt(param.getMoney());
		int idx = accounts.indexOf(a);
		accounts.get(idx).setMoney(String.valueOf(budget));
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		AccountBean a = findByAccountNum(accountNum);
		accounts.remove(a);
	}


}