package org.example.library.mapper;

import org.apache.ibatis.annotations.*;
import org.example.library.model.PageRequest;
import org.example.library.module.BookInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Insert("insert into book_info (book_name, author, count, price, publish) VALUES (#{bookName}, #{author}, #{count}, #{price}, #{publish})")
    public Integer insert(BookInfo bookInfo);

    public Integer updateBook(BookInfo bookInfo);

    /**
     * 查询数据总数
     */
    @Select("select count(1) from book_info where status<>0")
    public Integer count();

    /**
     * 查询当前页的数据
     */
    @Select("select * from book_info where `status`<>0 order by `id` desc limit #{offset},#{pageSize}")
    public List<BookInfo> queryListByPage(@RequestBody PageRequest pageRequest);

    @Select("select * from book_info where status<>0 and id=#{id}")
    public BookInfo queryBookById(Integer id);

    Integer batchDelete(List<Integer> ids);
}
