package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class BeanLifeCycleTest {
	@Test
	public void lifeCycleTest() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		NetworkClient client = ac.getBean(NetworkClient.class);
		ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
	}

	@Configuration
	static class LifeCycleConfig {
//		@Bean
		@Bean(initMethod = "init", destroyMethod = "close")
		public NetworkClient networkClient() {
			NetworkClient networkClient = new NetworkClient();
			// 객체가 생성된 후 수정자 주입을 통해 값이 들어올 수도 있다.
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}
}
