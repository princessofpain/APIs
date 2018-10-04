package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String TEMPLATE = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET) //this identifies the method greeting() to be mapped if the path /greeting is opened with a GET request 
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
	}
}
