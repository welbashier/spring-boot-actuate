package com.example.springboot;

import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // works with @@LocalServerPort
public class HelloControllerTest2 {

	//***************************************** start ******************************
	/**
	 * The embedded server starts on a random port because of 
	 * 		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, 
	 * and the actual port is discovered at runtime with @LocalServerPort.
	 */
	
	@LocalServerPort
	private int port;
	
	private URL baseUrl;
	

	@Autowired
	private TestRestTemplate template;
	
	@BeforeEach
	public void setUp() throws Exception {
		 this.baseUrl = new URL("http://localhost:" + port + "/");
	}

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = 
        		template.getForEntity(
        				baseUrl.toString(), /* using the URL of localhost and port */
        				String.class
        				);
        assertThat(response.getBody().equals("Greetings from Spring Boot!"));
    }
	//***************************************** end ********************************
}
