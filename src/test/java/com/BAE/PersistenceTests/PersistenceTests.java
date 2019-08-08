package com.BAE.PersistenceTests;

import org.junit.Test;

import com.BAE.domain.Account;

import junit.framework.Assert;

public class PersistenceTests {
	Account acc = new Account(2L, "Zilla", "god", "123456", "yes");

	@Test
	public void testGetterName() {

		Assert.assertEquals(acc.getFirstName(), "Zilla");
	}

	@Test
	public void testSetFirstName() {
		acc.setFirstName("Zilla");
		Assert.assertEquals(acc.getFirstName(), "Zilla");
	}
}

