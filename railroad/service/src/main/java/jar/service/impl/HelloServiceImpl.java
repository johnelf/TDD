package jar.service.impl;

import jar.service.HelloService;

public class HelloServiceImpl implements HelloService {
	public String hello(String name) {
		return "Hello there, " + name;
	}
}