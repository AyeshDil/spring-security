package com.myproject.security.springsecurity.config.permission;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.myproject.security.springsecurity.config.permission.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CUSTOMER(Sets.newHashSet(ORDER_WRITE, PRODUCT_READ, CUSTOMER_WRITE, CUSTOMER_READ)),
    MANAGER(Sets.newHashSet(ORDER_READ,PRODUCT_READ, CUSTOMER_READ)),
    ADMIN(Sets.newHashSet(ORDER_READ, ORDER_WRITE, PRODUCT_READ, PRODUCT_WRITE, CUSTOMER_READ, CUSTOMER_WRITE));

    private final Set<ApplicationUserPermission> permissionSet;


    ApplicationUserRole(Set<ApplicationUserPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<ApplicationUserPermission> getPermissionSet() {
        return permissionSet;
    }
}
