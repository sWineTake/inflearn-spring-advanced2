package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TimeInvocationHandler는 InvocationHandler 인터페이스를 구현합니다.
 * 이렇게 JDK 동적 프록시를 적용할 공통 로직을 개발을 할 수 있습니다.
 */
@Slf4j
public class TimeInvocationHandler implements InvocationHandler {
	// 프록시는 항상 호출 할 대상이 있어야 합니다.
	private final Object target;
	public TimeInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("Time Proxy 실행");
		long startTime = System.currentTimeMillis();

		// 실행시킬 대상과 파라미터들을 같이 보내줘야합니다.
		Object result = method.invoke(target, args);
		long endTime = System.currentTimeMillis();
		log.info("Time Proxy를 종료하고 resultTime : {}", endTime - startTime);
		return result;
	}
}
