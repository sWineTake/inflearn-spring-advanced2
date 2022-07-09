package hello.proxy.pureproxy.concreateproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

	private ConcreteLogic concreteLogic;

	public TimeProxy(ConcreteLogic concreteLogic) {
		this.concreteLogic = concreteLogic;
	}

	@Override
	public String operation() {
		log.info("TimeProxy 실행");
		long startTime = System.currentTimeMillis();

		// 프로세스 실제 로직
		String result = concreteLogic.operation();

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("TimeDecorator 종료시간 : {}", resultTime);
		return super.operation();
	}
}
