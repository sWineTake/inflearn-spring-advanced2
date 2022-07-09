package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

	@Test
	public void decoratorTest1() {
		Component component = new RealComponent();
		DecoratorPatternClient client = new DecoratorPatternClient(component);
		client.execute();
	}

	@Test
	public void decoratorTest2() {
		Component component = new RealComponent();
		MessageDecorator messageDecorator = new MessageDecorator(component);
		DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
		client.execute();
	}

	@Test
	public void decoratorTest3() {
		Component component = new RealComponent();
		Component messageDecorator = new MessageDecorator(component);
		Component timeDecorator = new TimeDecorator(messageDecorator);
		DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);

		client.execute();
	}

}
