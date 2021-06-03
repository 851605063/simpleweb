package com.qfggk.simpleweb.mapper;


import com.qfggk.simpleweb.bean.books;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface Mapper_bms_books {

    public books getBooks(int id);
}
