package com.BAE.service;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.BAE.domain.Account;
import com.BAE.repository.AccountRepository;
@RunWith(SpringRunner.class)
public class MockitoTest {
	@InjectMocks
	AccountServiceImpl service;
	
	@Mock
	AccountRepository repo;
	
	private static final Account fakeaccount1 = new Account(1L, "Kevin", "Mcfreedom", "1", "no");
	private static final Account fakeaccount2 = new Account(2L, "Mike", "Chowda", "2", "yes");
	
	@Test
	public void findAllTest() {
		List<Account> fakelist = new ArrayList<>();
		fakelist.add(fakeaccount1);
		fakelist.add(fakeaccount2);
		Mockito.when(repo.findAll()).thenReturn(fakelist);
		assertEquals(fakelist, service.findAll());
		Mockito.verify(repo).findAll();
	}
	
//	@Test
//	public void createAccountTest() {
//		Mockito.when(repo.save(fakeaccount1)).thenReturn(fakeaccount1);
//		assertEquals(fakeaccount1, service.createAccount(fakeaccount1));
//		Mockito.verify(repo).save(fakeaccount1);
//	}
	

}
