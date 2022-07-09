package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

	/**
	 * Client가 RealSubject를 바로 참조하고있으므로 요청당 실제 조회로직을 1번 실행
	 * 1번 실행당 1초가 소요됨으로 3번으 호출로 총 3초가 소요됨
	 * 같은 값을 여러번 요청함으로 비효율적이고 직접 RealSubject를 참조하고있으므로 ocp위배
	 */
	@Test
	public void proxyTest() {
		RealSubject subject = new RealSubject();
		ProxyPatternClient proxyPatternClient = new ProxyPatternClient(subject);
		proxyPatternClient.execute();
		proxyPatternClient.execute();
		proxyPatternClient.execute();
	}

	/**
	 * client > cacheProxy > realSubject 로 연결됨
	 * 요청당 1초가 소요되는것은 같지만 한번요청시 값을 저장하고있음
	 * 후 그 값을 cacheProxy가 저장하고있음, 똑같은 요청이 들어오면 cacheProxy가 가지고있는 값을 리턴
	 * 요청은 3번 이지만 실질적인 소요시간은 1초
	 */
	@Test
	public void proxyCacheTest() {
		RealSubject target = new RealSubject();
		CacheProxy cacheProxy = new CacheProxy(target);
		ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
		client.execute();
		client.execute();
		client.execute();
	}

}
