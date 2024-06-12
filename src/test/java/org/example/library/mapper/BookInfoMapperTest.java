package org.example.library.mapper;

import org.example.library.module.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookInfoMapperTest {
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Test
    void batchDelete() {
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        Integer result = bookInfoMapper.batchDelete(ids);
    }

    @Test
    void queryBookById() {
        BookInfo bookInfo = bookInfoMapper.queryBookById(2);
        if (bookInfo != null) {
            System.out.println(bookInfo);
        }else{
            System.out.println("null!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}