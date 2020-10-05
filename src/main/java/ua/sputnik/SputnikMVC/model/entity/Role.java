package ua.sputnik.SputnikMVC.model.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Barma
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
