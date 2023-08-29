package pl.sda.springecommerce.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("ADMIN"),
    USER("USER");
    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
