package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.model.Person;


@RestController
@RequestMapping("/user-details")
public class Controller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public Person getDetails(@PathVariable("id") String id)
	{
		ResponseEntity<String> name = restTemplate.exchange("http://localhost:8081/ms1/empidpass/1",HttpMethod.GET,null,String.class);
		ResponseEntity<String> salary = restTemplate.exchange("http://localhost:8082/ms2/validateidpass/1",HttpMethod.GET,null,String.class);
		Person p =new Person();
		p.setName(name.getBody());
		p.setSalary(salary.getBody());
		return p;
	}
}

/*
//@RestController
//@RequestMapping("/user-details")
//public class Controller {
//
//    private final RestTemplate restTemplate;
//
//    // Inject RestTemplate using constructor injection
//    public Controller(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @GetMapping("/{id}")
//    public Person getDetails(@PathVariable("id") String id) {
//        ResponseEntity<Map> nameResponse = restTemplate.exchange(
//            "http://localhost:8081/ms1/empidpass/1",
//            HttpMethod.GET,
//            null,
//            Map.class
//        );
//
//        ResponseEntity<Map> salaryResponse = restTemplate.exchange(
//            "http://localhost:8082/ms2/validateidpass/1",
//            HttpMethod.GET,
//            null,
//            Map.class
//        );
//
//        Person p = new Person();
//        p.setName((String) nameResponse.getBody().get("name"));
//        p.setSalary((String) salaryResponse.getBody().get("salary"));
//        return p;
//    }
//}
 */