package hello.proxy.pureproxy.concreateproxy;

import hello.proxy.pureproxy.concreateproxy.code.ConcreteClient;
import hello.proxy.pureproxy.concreateproxy.code.ConcreteLogic;
import hello.proxy.pureproxy.concreateproxy.code.TimeProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ConcreteProxyTest {

	@Test
	void noProxy() {
		ConcreteLogic concreteLogic = new ConcreteLogic();
		ConcreteClient create = new ConcreteClient(concreteLogic);
		create.execute();
	}


	@Test
	void addProxy() {
		ConcreteLogic concreteLogic = new ConcreteLogic();
		TimeProxy timeProxy = new TimeProxy(concreteLogic);
		ConcreteClient create = new ConcreteClient(timeProxy);
		create.execute();
	}

}
