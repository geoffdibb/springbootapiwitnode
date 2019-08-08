package com.BAE.rest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import com.BAE.domain.Account;
import com.BAE.service.AccountService;

@RunWith(SpringRunner.class)
public class MockTests {
	
	@InjectMocks
	AccountController controller;

	@Mock
	AccountService service;
	
	@Mock
	RestTemplate resttemp;
	
	private static final Account fakeaccount1 = new Account(1L, "Kevin", "Mcfreedom", "1", "no");
	private static final Account fakeaccount2 = new Account(2L, "Mike", "Chowda", "2", "yes");
	
	@Test
	public void getAllAccounts() {
		List<Account> fake_list = new ArrayList<>();
		fake_list.add(fakeaccount1);
		fake_list.add(fakeaccount2);
		Mockito.when(service.findAll()).thenReturn(fake_list);
		assertEquals(fake_list, controller.getAllAccount());
		Mockito.verify(service).findAll();
	}
	
	@Test
	public void deleteAccountsTest() {
		Mockito.when(service.deleteAccount(fakeaccount1)).thenReturn("Deleted");
		assertEquals("Deleted", controller.deleteAccount(fakeaccount1));
		Mockito.verify(service).deleteAccount(fakeaccount1);
	}
	
	
	@Test
	public void createAccountTest() {

		Mockito.when(service.createAccount(fakeaccount1)).thenReturn(fakeaccount1);

		assertEquals(fakeaccount1, controller.createAccount(fakeaccount1).getBody());
		Mockito.verify(service).createAccount(fakeaccount1);
	}
	
	@Test
	public void updateAccountTest() {
		Mockito.when(service.updateAccount(fakeaccount1)).thenReturn(fakeaccount1.toString());

		assertEquals(fakeaccount1.toString(), controller.updateAccount(fakeaccount1));
		Mockito.verify(service).updateAccount(fakeaccount1);
	}
	
}
