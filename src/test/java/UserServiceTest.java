import com.gs.app.hiber.api.domain.User;
import com.gs.app.hiber.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2017/8/4.19:41..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest {

    @Resource
    private UserService userService;


    @Test
    public void findUserByUserName() {
        User admin = userService.findUserByUserName("admin");
        System.out.println(admin+"s");
    }

}
