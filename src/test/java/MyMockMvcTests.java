import com.seguoer.MyApplication;
import com.seguoer.config.MyProperties;
import com.seguoer.po.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
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
        Assertions.assertEquals(new Date(2021 - 1900, Calendar.MAY, 1, 12, 12, 12), person.getBirth());
        Assertions.assertEquals(5, person.getAge());
        Assertions.assertEquals("[zcy, hjf]", Arrays.toString(person.getInterests()));
        Assertions.assertEquals("[mouse, cat, sheep]", person.getAnimal().toString());
        Assertions.assertEquals("{mouse1={name=mouse1, age=12}, mouse2={name=mouse2, age=24}}", person.getScore().toString());
        Assertions.assertEquals("[1.12, 2.34, 3.16]", person.getSalaries().toString());
        Assertions.assertEquals("Pet{name='pet1', age=15}", person.getPet().toString());
        Assertions.assertEquals("{hjf=[Pet{name='dog1', age=15}, Pet{name='cat1', age=5}], zcy=[Pet{name='dog2', age=18}, Pet{name='cat2', age=8}]}", person.getAllPets().toString());

    }

    @Test
    @DisplayName("几个文件夹下的静态可以直接通过文件名直接访问，如果静态前缀设置了则需要加上前缀(前缀取消所以不需要前缀)")
    void demo1213(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/demo1.html"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("webjars访问，静态前缀不需要再写了")
    void webjars(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/webjars/bootstrap/css/bootstrap.css"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("因为这里是向请求体发请求，所以不需要@Requestbody")
    void person(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("userName", "asd")
                        .param("pet.name", "pet")
                        .param("pet.age", "12"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("userName").value("asd"))
                .andExpect(MockMvcResultMatchers.jsonPath("pet.name").value("pet"))
                .andExpect(MockMvcResultMatchers.jsonPath("pet.age").value("12"));
    }

    @Test
    @DisplayName("对比自己创建了对应的converter时，可以根据个人自定义如何赋值")
    void personConverter(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("userName", "asd")
                        .param("pet", "asda,12"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("userName").value("asd"))
                .andExpect(MockMvcResultMatchers.jsonPath("pet.name").value("asda"))
                .andExpect(MockMvcResultMatchers.jsonPath("pet.age").value("12"));
    }

    @Test
    @DisplayName("对返回的内容可以自己来做一些预处理")
    void personConverterForm(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/person")
                        .accept("applications/x-custom")
                        .param("userName", "asd")
                        .param("pet.name", "pet")
                        .param("pet.age", "12"))
                .andExpect(status().isOk())
                .andExpect(content().string("Person;15;other abandon"));
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

