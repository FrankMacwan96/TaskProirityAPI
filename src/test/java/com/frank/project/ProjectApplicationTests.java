package com.frank.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frank.project.controller.TaskController;
import com.frank.project.model.Task;
import com.frank.project.service.TaskService;
import com.mysql.cj.protocol.x.Ok;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TaskController.class)
@ContextConfiguration(classes = ProjectApplication.class)
class ProjectApplicationTests {

	@Autowired
	private MockMvc m;

	@MockBean
	private TaskService taskService;

	@Test
	void testGetOneTask() throws Exception {
		// RequestBuilder rq =
		// MockMvcRequestBuilders.get("http://localhost:3001/task/getOne/1");

		Task t = new Task();
		
		t.setId((long) 1);
		t.setDescrption("descrption");
		t.setPriority((long) 11);

		when(taskService.getTaskdata(anyLong())).thenReturn(Optional.of(t));
		
		String s = m.perform(MockMvcRequestBuilders.get("http://localhost:3001/task/getAll")).andReturn().getResponse().getContentAsString();
		
		String m = t.toString();
		
		assertEquals(s, m);


		
	}


}

https://teams.microsoft.com/l/meetup-join/19%3ameeting_ZjFlNTEyZjctYjQ2YS00Zjk4LTlhODMtMjJmZGExODNhYzMy%40thread.v2/0?context=%7b%22Tid%22%3a%228ff33436-4701-4dad-b7d3-3462e99c6889%22%2c%22Oid%22%3a%2291709a04-cf7c-48e7-bdb5-ea2830304e8a%22%7d