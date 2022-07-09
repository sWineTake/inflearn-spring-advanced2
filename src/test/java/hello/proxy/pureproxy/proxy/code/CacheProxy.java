package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

	private Subject target;
	private String data;
	public CacheProxy(Subject target) {
		this.target = target;
	}

	@Override
	public String operation() {
		log.info("캐쉬 프록시 호출");
		if (data != null) {
			data = target.operation();
		}
		return data;
	}
}
