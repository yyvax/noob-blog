package properties;

import com.nooblog.properties.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogProperties.class)
public class BlogPropertiesTest {

    @Autowired
    BlogProperties blogProperties;

    @Test
    public void testProperties() {
        Assert.assertEquals(blogProperties.getName(), "yyvax");
        Assert.assertEquals(blogProperties.getTitle(), "Welcome to noob's blog");
    }

}
