package ch.zli.m223.ksh18a.mia.crm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh18a.mia.crm.service.TerminService;


/**
 * @author Mia Gudelj
 * @since 15-07-2021
 */

@RestController()
@RequestMapping("rest/v1/termin")
public class TerminController {

	// variables
	@Autowired
	private TerminService terminService;

	
	/**
	 * gets all termine
	 * 
	 * @return list of all users
	 */
	@GetMapping("/list")
	public List<TerminDto> getAllTermine() {
		// List<UserDto> res = new ArrayList<>();
		// res.add(new UserDto("user1"));
		// res.add(new UserDto("user2"));
		return terminService.getAllTermine().stream().map(termin -> new TerminDto(termin)).collect(Collectors.toList());
		// turns userDto to user
	}

	/**
	 * creates a new user
	 * 
	 * @param terminInput
	 * @return new user into userService
	 */
	@PostMapping("/create")
	public TerminDto createTermin(@RequestBody TerminInputDto terminInput) {
		return (TerminDto) terminService.addTermin(
				terminInput.beschreibung, 
				terminInput.date);
	}

	/**
	 * deletes termin by id
	 * 
	 * @param terminId
	 * @return
	 */
	@DeleteMapping("/delete/{terminId}")
	public TerminDto deleteTerminById(@PathVariable("terminId") long terminId) {
		return new TerminDto(terminService.getTerminById(terminId));
	}

	/**
	 * gets termin by id
	 * 
	 * @param userId
	 */
	@GetMapping("/read/{terminId}")
	public void getTerminById(@PathVariable("terminId") long terminId) {
		terminService.getTerminById(terminId);
	}

}
