package user;

import com.nooblog.controller.UserController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class)
public class UserControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testCRUDUser() throws Exception {
        RequestBuilder request = null;

        // create
        request = MockMvcRequestBuilders.post("/users/")
                .param("id", "0001")
                .param("name", "eric")
                .param("password", "smsmsmsm1234");
        mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("eric")));

        // read
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request).andExpect(MockMvcResultMatchers.content()
                .string(Matchers.equalTo("[{\"id\":1," +
                        "\"name\":\"eric\",\"password\":\"smsmsmsm1234\"}]")));

        // update existed model
        request = MockMvcRequestBuilders.put("/users/0001")
                .param("name", "deadr")
                .param("password", "jianfeijianfei123");
        mvc.perform(request).andExpect(MockMvcResultMatchers.content()
                .string(Matchers.equalTo("Updated. New model: deadr")));

        // update non-existed model
        request = MockMvcRequestBuilders.put("/users/1201")
                .param("name", "morrel")
                .param("password", "2513");
         mvc.perform(request).andExpect(MockMvcResultMatchers.content()
                .string(Matchers.equalTo("No model existed. Created model: morrel")));

         // delete non-existed model
        request = MockMvcRequestBuilders.delete("/users/2222");
        mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(
                Matchers.equalTo("User 2222 doesn't exist.")
        ));

        // delete a model
        request = MockMvcRequestBuilders.delete("/users/0001");
        mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(
                Matchers.equalTo("Deleted model: 1")));

    }

}
