/**
 * communication between client and service
 */
package ch.zli.m223.ksh18a.mia.crm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh18a.mia.crm.model.AppUser;
import ch.zli.m223.ksh18a.mia.crm.model.Termin;
import ch.zli.m223.ksh18a.mia.crm.service.UserService;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */

@RestController()
@RequestMapping("rest/v1/users")
public class UserController {

	// variables
	@Autowired
	private UserService userService;

	
	/**
	 * gets all users
	 * 
	 * @return list of all users
	 */
	@GetMapping("/list")
	public List<UserDto> getAllUsers() {
		// List<UserDto> res = new ArrayList<>();
		// res.add(new UserDto("user1"));
		// res.add(new UserDto("user2"));
		return userService.getAllUsers().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
		// turns userDto to user
	}

	/**
	 * inserts a new user
	 * 
	 * @param userInput
	 * @return new user into userService
	 */
	@PostMapping("/create")
	public UserDto createUser(@RequestBody UserInputDto userInput) {
		return (UserDto) userService.addUser(
				userInput.userName, 
				userInput.password,
				userInput.roles);
		// TODO
	}

	/**
	 * deletes user by id
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping("delete/{userId}")
	public UserDto deleteUserById(@PathVariable("userId") long userId) {

		return new UserDto(userService.getUserById(userId));
	}

	/**
	 * gets user by id
	 * 
	 * @param userId
	 */
	@GetMapping("read/{userId}")
	public void getUserById(@PathVariable("userId") long userId) {
		userService.getUserById(userId);
	}
	
	/**
	 * sets roles of a user
	 * 
	 * @param id
	 * @param roles
	 * @return roles
	 */
	@PutMapping("/{userId}/roles")
	public UserDto setRoles(@PathVariable("userId") long userId, RoleInputDto roles) {
		AppUser user = userService.setRolesForUser(userId, roles.roles);
		return new UserDto(user);
	}
	
	@PutMapping("/{userId}/termine")
	public TerminDto addTermine(@PathVariable("userId") long userId, @RequestBody TerminInputDto terminDto) {
		Termin termin = userService.addTerminToUser(userId, terminDto.beschreibung, terminDto.date);
		return new TerminDto(termin);
	}
}
