package com.pathz.appcontext;

import com.pathz.appcontext.app.context.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppcontextApplicationTests {

	public static final String SCANNING_PACKAGE = "com.pathz.appcontext.app.components";

	@Test
	void contextLoads() {
	}

	@Test
	void scanPackage() {
		ApplicationContext applicationContext = new ApplicationContext(SCANNING_PACKAGE);
		Assertions.assertThat(applicationContext.resolveComponents()).containsKeys("myCar", "myPerson");
	}

}
