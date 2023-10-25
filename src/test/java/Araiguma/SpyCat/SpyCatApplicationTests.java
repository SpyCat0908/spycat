package Araiguma.SpyCat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Services.UserService;
import Araiguma.SpyCat.dtos.UserInputDTO;

@SpringBootTest
class SpyCatApplicationTests {

	private UserService service;
	private User user;
	private UserInputDTO dto;

	@BeforeAll
	public void setup(){
		UserService userService = new UserService();
	}


	@Test
	void createUser() {
		UserInputDTO userInputDTO = new UserInputDTO("caio@gmai.bao", "MAarcola", "123", "floripa", "ioio");

		service.create(userInputDTO);

	}

}


//