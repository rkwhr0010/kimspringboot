package kimspring.helloboot;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 디스패처 서블릿은 빈으로 등록된 객체 중 RequestMapping을 가진 빈을 탐색해
 * 매핑 테이블을 만들어, 사용한다. 이때 클래스 레벨에 RequestMapping을 탐색해
 * 만들기 때문에 메서드 레벨에만 붙이면 매핑 테이블에 등록이 안된다.
 */
@RestController
public class HelloController {
	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		super();
		this.helloService = helloService;
	}
	@GetMapping("/hello")
	public String hello (String name) {
		if(name == null || name.trim().length() ==0) throw new IllegalArgumentException();
		return helloService.sayHello(name);
	}
	@PostMapping("/hello")
	public String hello2 (String name) {
		if(name == null || name.trim().length() ==0) throw new IllegalArgumentException();
		return helloService.sayHello(name);
	}
	
	@GetMapping("/count")
	public String count(String name) {
		return "count : "+helloService.countOf(name);
	}
	
	@GetMapping("/test")
	public String newIntance(ObjectMapper mapper) {
		ObjectMapper mapper2 = new ObjectMapper();
		System.out.println(mapper);
		System.out.println(mapper2);
		
		return mapper.equals(mapper2)+"";
	}
	
}
