import com.seguoer.MyApplication;
import com.seguoer.config.MyProperties;
import com.seguoer.po.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MyApplication.class)
@AutoConfigureMockMvc
public class MyMockMvcTests {

    @Test
    @DisplayName("使用模拟环境进行测试")
    void testWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }
    @Test
    @DisplayName("测试配置文件里面的值是否被赋")
    void testMyProreties(@Autowired MyProperties myProperties) throws Exception {
        Assertions.assertEquals("zcy", myProperties.getName());
        Assertions.assertEquals("haha", myProperties.getTarget());
    }
    @Test
    @DisplayName("测试配置文件里面的值是否被赋")
    void testMyPerson(@Autowired Person person) {
        Assertions.assertEquals("feige", person.getUserName());
        Assertions.assertEquals(false, person.getBoss());
        Assertions.assertEquals(new Date(2021-1900, Calendar.MAY,1,12,12,12), person.getBirth());
        Assertions.assertEquals(5,person.getAge());

    }

    // If Spring WebFlux is on the classpath, you can drive MVC tests with a WebTestClient
    /*@Test
    void testWithWebTestClient(@Autowired WebTestClient webClient) {
        webClient
                .get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello World!");
    }*/

}

