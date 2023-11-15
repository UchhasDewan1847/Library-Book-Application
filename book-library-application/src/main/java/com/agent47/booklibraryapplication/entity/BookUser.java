package com.agent47.booklibraryapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
public class BookUser {
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
    private String role;
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
}
