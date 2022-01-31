package netumbackend.summer2022.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import netumbackend.summer2022.domain.Person;
import netumbackend.summer2022.domain.PersonRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/persons", produces = "application/json")
public class PersonController {

	private final PersonRepository personRepository;

	PersonController(PersonRepository personRepository) {

		this.personRepository = personRepository;
	}

	// List of persons in the database

	@GetMapping
	public @ResponseBody List<Person> personListRest() {

		return (List<Person>) personRepository.findAll();
	}

	// One specific person in database

	@GetMapping("/{id}")
	public @ResponseBody Optional<Person> findPersonRest(@PathVariable("id") Long person_id) {

		return personRepository.findById(person_id);
	}

	// Add a new person to database

	@PostMapping
	public ResponseEntity<Person> addPersonRest(@RequestBody Person person) {

		personRepository.save(person);
		
		return new ResponseEntity<>(person, HttpStatus.CREATED);
	}

	// Delete a person from database

	@DeleteMapping("/{id}")
	public HttpStatus deletePersonRest(@PathVariable("id") Long person_id) {

		personRepository.deleteById(person_id);
		
		return HttpStatus.ACCEPTED;
	}

	// Update persons information within database

	@PutMapping("/{id}")
	public Optional<Object> updatePersonRest(@RequestBody Person Person, @PathVariable("id") Long person_id) {

		return personRepository.findById(person_id).map(person -> {
			person.setFirst_name(Person.getFirst_name());
			person.setLast_name(Person.getLast_name());
			person.setAge(Person.getAge());

			personRepository.save(person);

			return new ResponseEntity<>(person, HttpStatus.CREATED);
		});
	}
}
