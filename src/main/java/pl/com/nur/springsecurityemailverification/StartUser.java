package pl.com.nur.springsecurityemailverification;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.com.nur.springsecurityemailverification.model.AppRole;
import pl.com.nur.springsecurityemailverification.model.AppUser;
import pl.com.nur.springsecurityemailverification.repository.AppUserRepo;

@Component
public class StartUser {

    private PasswordEncoder passwordEncoder;
    private AppUserRepo appUserRepo;

    public StartUser(PasswordEncoder passwordEncoder, AppUserRepo appUserRepo) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepo = appUserRepo;

        AppUser appUser = new AppUser();
        appUser.setUsername("Wojtek");
        appUser.setPassword(passwordEncoder.encode("1234"));
        appUser.setRole(AppRole.ADMIN);
        appUser.setEnabled(true);
        appUserRepo.save(appUser);

        AppUser appUser1 = new AppUser();
        appUser1.setUsername("Iza");
        appUser1.setPassword(passwordEncoder.encode("1234"));
        appUser1.setRole(AppRole.USER);
        appUser1.setEnabled(true);
        appUserRepo.save(appUser1);
    }
}
