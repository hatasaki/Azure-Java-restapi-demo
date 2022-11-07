package com.example.restapidemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	private final AtomicInteger counter = new AtomicInteger();
	private List<User> u = new ArrayList<User>();

	@PostMapping("/api/newuser")
	public User newuser(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
						@RequestParam(value = "city", defaultValue = "None") String city) {
		int id = counter.incrementAndGet();
		u.add(new User(id, name, city));
		return u.get(id-1);
	}
 
	@GetMapping("/api/getuser")
	public User getuser(@RequestParam(value = "id") String id) {
		return u.get(Integer.parseInt(id)-1);
	}

}