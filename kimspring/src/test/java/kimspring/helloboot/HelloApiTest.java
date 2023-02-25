package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {
	
	@Test
	void helloApi() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class,"boot");
		//HTTP 3요소 검증, 상태코드,헤더,바디
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
		assertThat(entity.getBody()).isEqualTo("Hello boot");
	}
	
}
