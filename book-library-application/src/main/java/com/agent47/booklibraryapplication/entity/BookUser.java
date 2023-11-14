package com.agent47.booklibraryapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "email_constraint",
                columnNames = {"email","password"}
        )
)
public class BookUser implements UserDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID userId;
    private String firstName;
    private String lastName;
    @NotBlank
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    @NotBlank
    @Column(
            name = "password",
            nullable = false

    )
    private String password;
    private String address;
    @ManyToMany(
    )
    @JoinTable(
            name = "borrowed_books",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id",
            referencedColumnName = "bookId")
    )
    private List<Book> books;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
