package com.qfggk.simpleweb.service.imp;

import com.qfggk.simpleweb.bean.books;
import com.qfggk.simpleweb.mapper.Mapper_bms_books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

    @Autowired(required = false)
    Mapper_bms_books mapper_bms_books;

    public books getBooksById(int id)
    {
       return mapper_bms_books.getBooks(id);

    }
}
