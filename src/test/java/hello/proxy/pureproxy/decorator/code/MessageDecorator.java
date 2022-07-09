package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{
	private Component component;
	public MessageDecorator(Component component) {
		this.component = component;
	}

	@Override
	public String operation() {
		String result = component.operation();
		String decoResult = "******" + result + "******";
		log.info("변경전 : {}, 변경 후 : {}", result, decoResult);
		return decoResult;
	}
}
