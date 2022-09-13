package moscato.admin.login;

import groovy.util.logging.Slf4j;
import moscato.admin.service.login.Admin;
import moscato.admin.service.login.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AdminServiceTest {
    
    @Autowired
    AdminService adminService;
    
    @Test
    void 어드민가입테스트() {
        // 그냥 테스트용이니 건들지 말것
        Admin admin = new Admin();
        admin.setAdminId("master");
        admin.setAdminName("관리자");
        admin.setPassword("1234");
        admin.setAuth(1);
        int save = adminService.save(admin);
    }
}
