package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

	@Test
	void reflection0() {
		Hello target = new Hello();

		// 공통 로직1 시작
		log.info("start");
		String callA = target.callA(); // 호출메서드만 다름
		log.info("result : {}", callA);

		// 공통 로직1 시작
		log.info("start");
		String callB = target.callA();
		log.info("result : {}", callB);
	}

	@Test
	void reflection1() throws Exception {
		// 클래스 정보
		Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

		Hello target = new Hello();
		// callA 메서드 정보
		String classA = "callA";
		Method methodHelloA = classHello.getMethod(classA);
		Object resultA = methodHelloA.invoke(target);
		log.info("result = {}", resultA);

		// callB 메서드 정보
		String classB = "callB";
		Method methodHelloB = classHello.getMethod(classB);
		Object resultB = methodHelloB.invoke(target);
		log.info("result = {}", resultB);
	}

	@Test
	void reflection2() throws Exception{
		Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");
		dynamicCall(classHello.getMethod("callA"), new Hello());
		dynamicCall(classHello.getMethod("callB"), new Hello());
		// 정리 -->
		// 정적인 target.callA(), target.callB() 코드를 리플렉션을 사용해서 Method라는 메타정보로 추상화했습니다.
		// 덕분에 공통 로직을 만들 수 있게 되었습니다.

		// 단점 -
		// 리플렉션은 최대한 지양해야합니다. 왜냐하면 리플렉션 기술은 런타임에서는 잡을 수 없습니다.
		// 실행 후 텍스트로 클래스명을 받기에 오타로 실행오류가 발생합니다.


	}

	private void dynamicCall(Method method, Object target) throws Exception {
		// Object target으로는 실제 실행할 인스턴스가 들어오게됩니다.
		// Object 라는 것은 어떠한 인스턴스를 모두 받을수 있습니다.
		// 물론 method.invoke(target)을 사용할 때 클래스와 메서드 정보가 서로 다르면 예외가 발생합니다.

		log.info("start");
		Object result = method.invoke(target);
		log.info("result = {}", result);
	}

	@Slf4j
	static class Hello {
		public String callA() {
			log.info("Call A");
			return "CALL A!";
		}

		public String callB() {
			log.info("Call B");
			return "Call B!";
		}
	}



}
