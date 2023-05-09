package learn.restapi.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	// http://localhost:8080/v1/person
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	// http://localhost:8080/v2/person
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	
	// http://localhost:8080/person?version=1
	@GetMapping(path = "person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonOnRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	// http://localhost:8080/person?version=2
	@GetMapping(path = "person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonOnRequestParameter() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	// Can be tested in Talend API, where we set header along with url
	// http://localhost:8080/person/header
	@GetMapping(path = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonOnRequestHeader() {
		return new PersonV1("Bob Charlie");
	}

	// Can be tested in Talend API, where we set header along with url
	// http://localhost:8080/person/header
	@GetMapping(path = "person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonOnRequestHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	// Can be tested in Talend API, where we set accept header along with url
	// http://localhost:8080/person/accept
	@GetMapping(path = "person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonOnRequestAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	// Can be tested in Talend API, where we set accept header along with url
	// http://localhost:8080/person/accept
	@GetMapping(path = "person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonOnRequestAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
