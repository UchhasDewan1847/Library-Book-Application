package com.agent47.booklibraryapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDto {
    private String bookName;
    private String authorName;
    private Double bookOnStock;
}
