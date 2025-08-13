package mylab.user.di;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testDiWiring() {
        assertNotNull(userService, "UserService 주입 필요");
        assertNotNull(userService.getUserRepository(), "UserRepository 주입 필요");
        assertEquals("MySQL", userService.getUserRepository().getDbType());
        assertNotNull(userService.getSecurityService(), "SecurityService 주입 필요");
    }

    @Test
    void testRegisterUser() {
        assertTrue(userService.registerUser("alice", "password123"));
        assertFalse(userService.registerUser("", ""));
    }
}
