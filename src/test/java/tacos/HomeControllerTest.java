package tacos;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class) //web test for HomeController
public class HomeControllerTest {
	@Autowired
	private MockMvc mockMvc;	//Injects MockMvc
	
	@Test
	void testHomePage() throws Exception {
		mockMvc.perform(get("/"))		//Performs 'GET /'
			.andExpect(status().isOk())	//Expects HTTP 200
			.andExpect(view().name("home"))	//Expects home view
			.andExpect(content().string(containsString("Welcome to Taco Cloud"))); //Expects 'Welcome to Taco Cloud'
			
	}
}
