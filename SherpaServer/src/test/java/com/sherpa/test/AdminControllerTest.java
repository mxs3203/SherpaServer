package com.sherpa.test;

import com.sherpa.controller.AdminController;
import com.sherpa.dto.AdminDto;
import com.sherpa.service.AdminService;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdminControllerTest {

	private MockMvc mockMvc;

	@Mock
	private AdminService adminService;

	@InjectMocks
	private AdminController adminController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
	}

	@Test
	public void test_get_by_id_success() throws Exception {

		AdminDto admin = new AdminDto();
		admin.setAdminId(1);
		admin.setUsername("admin");
		admin.setPassword("admin");

		long assertId = admin.getAdminId();

		when(adminService.findById(assertId)).thenReturn(admin);

		mockMvc.perform(get("/admins/admin/{id}", assertId)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.adminId", is(assertId))).andExpect(jsonPath("$.username", is("admin")))
				.andExpect(jsonPath("$.password", is("admin")));

		verify(adminService, times(1)).findById(assertId);
		verifyNoMoreInteractions(adminService);

	}

	@Test
	public void test_get_by_id_fail_bad_request() throws Exception {

		long assertId = -1;

		when(adminService.findById(assertId)).thenReturn(null);

		mockMvc.perform(get("/admins/admin/{id}", assertId)).andExpect(status().isBadRequest());

		verify(adminService, times(1)).findById(assertId);
		verifyNoMoreInteractions(adminService);

	}

}
