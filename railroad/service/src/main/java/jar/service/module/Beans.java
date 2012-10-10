package jar.service.module;

import jar.service.impl.HelloServiceImpl;
import jar.service.HelloService;
import no.tornado.inject.module.Provides;

public class Beans {
	@Provides(service = HelloService.class)
	HelloService helloService() {
		return new HelloServiceImpl();
	}
}