package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

	@Test
	void dynamicA() {
		AInterface target = new AImpl();
		// 프록시가 실행할 대상
		TimeInvocationHandler handler = new TimeInvocationHandler(target);

		// JAVA에서 제공해주는 프록시

		// 첫번째 인자 : 프록시가 어디 생성될지, 클래스 오더를 지정해줘야 합니다.
		// 두번째 인자 : 프록시를 어떠한 인터페이스로 만들지 지정해줘야합니다.(여러개 가능)
		// 세번째 인자 : 프록시가 호출할 로직
		AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);
		// proxy : newProxyInstance하면 동적으로 프록시를 생성합니다.
		// 어느클래스 로더에 할지, 어떠한 인터페이스로 할지, 프록시가 실제 사용해야할 로직

		// proxy는 생성시킬때 handler를 실행시킵니다.
		// proxy.call -> handler의 invoke를 실행합니다.
		// invoke를 호출 할때 파라미터 인자중 Method의 값이 call이 호출됩니다.
		proxy.call();
		log.info("targetClass : {}", target.getClass());
		log.info("proxyClass : {}", proxy.getClass());
	}

	@Test
	void dynamicB() {
		BInterface target = new BImpl();
		// 프록시가 실행할 대상
		TimeInvocationHandler handler = new TimeInvocationHandler(target);

		BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);
		proxy.call();
		log.info("targetClass : {}", target.getClass());
		log.info("proxyClass : {}", proxy.getClass());
	}
}
