package jar.client.module;

import no.tornado.inject.Eager;
import jar.client.HelloClient;

public class Beans {
	@Eager
	HelloClient helloClient() {
		return new HelloClient();
	}
}