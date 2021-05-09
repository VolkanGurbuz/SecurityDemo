package com.example.securitydemo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.securitydemo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
    return getAppUser().stream().filter(name -> username.equals(name.getUsername())).findFirst();
  }

  private List<ApplicationUser> getAppUser() {
    List<ApplicationUser> applicationUsers =
        Lists.newArrayList(
            new ApplicationUser(
                STUDENT.getGrantedAuthorities(),
                "annasmith",
                passwordEncoder.encode("pass123"),
                true,
                false,
                true,
                true),
            new ApplicationUser(
                ADMIN.getGrantedAuthorities(),
                "linda",
                passwordEncoder.encode("pass123"),
                true,
                false,
                true,
                true),
            new ApplicationUser(
                ADMINTRAINEE.getGrantedAuthorities(),
                "tom",
                passwordEncoder.encode("pass123"),
                true,
                false,
                true,
                true));

    return applicationUsers;
  }
}
