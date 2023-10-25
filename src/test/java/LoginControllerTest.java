import com.seguoer.MyApplication;
import com.seguoer.config.MyConfig;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(classes = MyApplication.class)
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Autowired
    MockMvc mvc;
    @Test
    @DisplayName("测试国际化 - zh - 模拟浏览器切换语言为中文")
    void i18nCN() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/login")
                        .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                )
                .andExpect(content().string(StringContains.containsString("邮箱")))
        ;
    }
    @Test
    @DisplayName("测试国际化 - en - 模拟浏览器切换语言为英文")
    void i18nUS() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/login")
                        .header("Accept-Language", "en")
                )
                .andExpect(content().string(StringContains.containsString("Email address")))
        ;
    }
}
