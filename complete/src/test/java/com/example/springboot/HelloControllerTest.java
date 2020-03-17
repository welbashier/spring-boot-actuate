package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	/**
	 * MockMvc comes from Spring Test and lets you, through a set of convenient builder classes, 
	 * send HTTP requests into the DispatcherServlet and make assertions about the result. 
	 * Note the use of @AutoConfigureMockMvc and @SpringBootTest to inject a MockMvc instance.
	 * 
	 * An alternative would be to ask Spring Boot to create only the web layers of the context 
	 * by using @WebMvcTest.
	 * 
	 */
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getHello_Get() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/")
				.accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Greetings from Spring Boot!\nThis is Get")));
	}
	
	@Test
	public void getHello_Put() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/")
				.accept(MediaType.APPLICATION_JSON);
		ResultMatcher matcher = status().is(200);
		ResultMatcher matcher2 = content().string(equalTo("Greetings from Spring Boot!\nThis is Put"));
		
		mvc.perform(requestBuilder)
		.andExpect(matcher)
		.andExpect(matcher2);
	}
	
	@Test
	public void getHello_Post() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!\nThis is Post")));
	}
}
