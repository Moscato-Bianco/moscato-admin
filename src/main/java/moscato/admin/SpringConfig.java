package moscato.admin;

import moscato.admin.service.category.CategoryRepository;
import moscato.admin.service.category.CategoryService;
import moscato.admin.service.login.AdminRepository;
import moscato.admin.service.login.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SpringConfig(AdminRepository adminRepository
                        , CategoryRepository categoryRepository
    ) {
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
    }

    @Bean
    public AdminService adminService() { return new AdminService(adminRepository);}

    @Bean
    public CategoryService categoryService() {return new CategoryService(categoryRepository);}
}
