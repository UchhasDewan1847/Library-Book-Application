package com.agent47.booklibraryapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID bookId;
    private String bookName;
    private String authorName;

}
