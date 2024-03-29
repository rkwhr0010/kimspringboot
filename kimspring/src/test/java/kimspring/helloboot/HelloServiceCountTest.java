package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class HelloServiceCountTest {
	@Autowired HelloService helloService;
	@Autowired HelloRepository helloRepository;
	
	@Test
	void sayHelloIncreaseCount() {
		IntStream.rangeClosed(1, 10).forEach(num->{
			helloService.sayHello("Kim");
			System.out.println(num);
			assertThat(helloRepository.countOf("Kim")).isEqualTo(num);
		});
		
	}
}
