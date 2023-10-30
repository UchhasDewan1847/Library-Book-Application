package com.agent47.booklibraryapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID bookId;
    private String bookName;
    private String authorName;
    private Double bookOnStock;
    @ManyToMany(
            mappedBy = "books",
            cascade = CascadeType.ALL
    )
    private List<BookUser> bookUsers;
}

