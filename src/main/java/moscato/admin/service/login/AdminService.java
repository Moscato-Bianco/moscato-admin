package moscato.admin.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin loadUserByUsername(String id) throws UsernameNotFoundException {
        return adminRepository.findByAdminId(id)
                .orElseThrow(() -> new UsernameNotFoundException(id));
    }

    public int save(Admin admin) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        admin.setPassword(encoder.encode(admin.getPassword()));

        return adminRepository.save(Admin.builder()
                .adminId(admin.getAdminId())
                .auth(admin.getAuth())
                .adminName(admin.getAdminName())
                .password(admin.getPassword()).build()).getAdminSeq();
    }
}
