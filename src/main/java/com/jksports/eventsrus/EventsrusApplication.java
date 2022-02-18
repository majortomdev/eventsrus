package com.jksports.eventsrus;

import com.jksports.eventsrus.model.Event;
import com.jksports.eventsrus.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventsrusApplication {

	public static void main(String[] args) {

		SpringApplication.run(EventsrusApplication.class, args);
	}

	CommandLineRunner run(EventRepository eventRepo) {
		return args -> {
			eventRepo.save(new Event(null,"Soccer","Dundalk","pat@abc.com",19.99, 15, null,null));
			eventRepo.save(new Event(null,"Poker","Marle","del@bigtree.com",35.50, 555, null,null));
			eventRepo.save(new Event(null,"Whist","Zurich","ss@deutch.com",8.00, 30, null,null));
		};
	}
}
