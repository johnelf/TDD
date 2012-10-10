package jar.client;

import no.tornado.inject.InitializingBean;
import jar.service.HelloService;
import no.tornado.inject.module.Require;

public class HelloClient implements InitializingBean {
	@Require(service = HelloService.class)
	private HelloService helloService;
	
	public void afterPropertiesSet() {
		String username = System.getProperty("user.name");
		String greeting = helloService.hello(username);
		System.out.println("Greeting from helloService: " + greeting);
	}
	
}