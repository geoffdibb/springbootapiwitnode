package com.BAE.service;

import java.util.List;
import java.util.Map;

import com.BAE.domain.Account;

public interface AccountService {

	List<Account> findAll();

	Account createAccount(Account account);

	String deleteAccount(Account account);

	String updateAccount(Account account);

}