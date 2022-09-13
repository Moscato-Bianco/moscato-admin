package moscato.admin;

import moscato.admin.service.login.AdminRepository;
import moscato.admin.service.login.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final AdminRepository adminRepository;

    @Autowired
    public SpringConfig(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Bean
    public AdminService adminService() { return new AdminService(adminRepository);}
}
