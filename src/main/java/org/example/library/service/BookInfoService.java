package org.example.library.service;

import org.example.library.mapper.BookInfoMapper;
import org.example.library.model.PageRequest;
import org.example.library.model.PageResult;
import org.example.library.module.BookInfo;
import org.example.library.module.BookStatusEnums;
import org.example.library.module.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    public Integer updateBook(BookInfo bookInfo){
        return bookInfoMapper.updateBook(bookInfo);
    }

    public Integer batchDelete(List<Integer> ids){
        return bookInfoMapper.batchDelete(ids);
    }

    public Integer insertBook(BookInfo bookInfo){
        return bookInfoMapper.insert(bookInfo);
    }

    public BookInfo queryBookById(Integer id){
        return bookInfoMapper.queryBookById(id);
    }

    public PageResult<BookInfo> queryListByPage(PageRequest pageRequest){
        //1. 查询记录总数
        Integer count = bookInfoMapper.count();
        //2. 查询当前页的数据
        List<BookInfo> bookInfoList = bookInfoMapper.queryListByPage(pageRequest);
        for(BookInfo bookInfo : bookInfoList){
            //3. 根据状态设置描述
            bookInfo.setStateCN(BookStatusEnums.getDescByCode(bookInfo.getStatus()).getDesc());
        }
        return new PageResult<>(bookInfoList,count,pageRequest);
    }
}
