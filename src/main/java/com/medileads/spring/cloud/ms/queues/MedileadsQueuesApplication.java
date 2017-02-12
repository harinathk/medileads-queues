package com.medileads.spring.cloud.ms.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class MedileadsQueuesApplication implements CommandLineRunner{
	private static List<Queue> queues = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(MedileadsQueuesApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		queues.add(new Queue("Venkat", "K", "MA", "S", Arrays.asList("123", "456")));
		queues.add(new Queue("Ramakrishna", "D", "MA", "S", Arrays.asList("456")));
		queues.add(new Queue("Harish", "K", "MA", "S", Arrays.asList("123")));	
	}
	
	@RequestMapping("/")
	public List<Queue> getQueues() {
		return queues;
	}
	
	@RequestMapping("/appointments/{id}")
	public List<Queue> getQueues(@PathVariable String id) {
		return queues.stream().filter(p -> p.getAppointments().contains(id)).collect(Collectors.toList());
	}
}

class Queue {
	private String firstName;
	private String lastName;
	private String homeState;
	private String shirtSize;
	private List<String> appointments;
	public Queue(String firstName, String lastName, String homeState,
			String shirtSize, List<String> appointments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeState = homeState;
		this.shirtSize = shirtSize;
		this.appointments = appointments;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHomeState() {
		return homeState;
	}
	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	public String getShirtSize() {
		return shirtSize;
	}
	public void setShirtSize(String shirtSize) {
		this.shirtSize = shirtSize;
	}
	public List<String> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<String> appointments) {
		this.appointments = appointments;
	}
}
