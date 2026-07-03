package com.library.book_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private long id;
    private String title;
    private String author;
}
