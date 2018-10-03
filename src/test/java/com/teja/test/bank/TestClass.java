package com.teja.test.bank;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.teja.bank.controller.CustomerController;
import com.teja.bank.model.BankAccount;
import com.teja.bank.model.Customer;
import com.teja.bank.repository.CustomerDao;
import com.teja.bank.service.CustomerService;

public class TestClass {
	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;
	
	private MockMvc mockMvc;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testAuthenticate() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerId(1234);
		customer.setPassword("te");
		customer = new Customer(null,1234,"te",null,null,
				null,null);
		Customer customer1 = new Customer("tejasree", 1234, "te", "vizag", "tej@gmail.com",
				LocalDate.of(1996,07,23), new BankAccount(1234, 1401, "SAVINGS"));

		/*when(((CustomerService) customer1).authenticate(customer)).thenReturn(customer1);

//		CustomerController sc= customerController.checking(null, null, null, 0, null);
		
		assertEquals(customer1, ((CustomerService) customer1).authenticate(customer));
		
*/
		
		
		when(customerService.authenticate(customer1)).thenReturn(customer);

		mockMvc.perform(post("/login.do").flashAttr("customer", customer1)).andExpect(view().name("displayDetails"))
				.andExpect(status().isOk());
		
		
		
	}
}
