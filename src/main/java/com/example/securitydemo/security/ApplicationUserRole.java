package com.example.securitydemo.security;

import java.util.Set;
import com.google.common.collect.Sets;
import lombok.Getter;

@Getter
public enum ApplicationUserRole {
  STUDENT(Sets.newHashSet(ApplicationUserPermission.COURSE_READ)),
  ADMIN(
      Sets.newHashSet(
          ApplicationUserPermission.COURSE_READ,
          ApplicationUserPermission.COURSE_WRITE,
          ApplicationUserPermission.STUDENT_READ,
          ApplicationUserPermission.STUDENT_WRITE));

  private final Set<ApplicationUserPermission> permissions;

  ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
    this.permissions = permissions;
  }
}
