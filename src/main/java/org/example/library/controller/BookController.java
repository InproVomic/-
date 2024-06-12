package org.example.library.controller;

import jakarta.servlet.http.HttpSession;
import org.example.library.constants.Constants;
import org.example.library.model.PageRequest;
import org.example.library.model.PageResult;
import org.example.library.model.Result;
import org.example.library.module.BookInfo;
import org.example.library.module.UserInfo;
import org.example.library.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookInfoService bookInfoService;

    @RequestMapping(value = "/addBook",produces = "application/json")
    public Result<String> addBook(BookInfo bookInfo) {
        if(!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getCount() <= 0
                || bookInfo.getPrice() == null){
            return Result.fail("参数错误");
        }

        bookInfoService.insertBook(bookInfo);
        return Result.success("添加成功啊！");
    }

    @RequestMapping("/getListByPage")
    public Result<PageResult<BookInfo>> getListByPage(PageRequest pageRequest, HttpSession httpSession) {
        UserInfo userInfo = (UserInfo) httpSession.getAttribute(Constants.USER_SESSION_KEY);
        if(userInfo == null) {
            return Result.unLogin();
        }

        if(pageRequest.getCurrentPage() < 0) {
            return Result.fail("非法参数");
        }

        PageResult<BookInfo> pageResult = bookInfoService.queryListByPage(pageRequest);
        return Result.success(pageResult);
    }

    @RequestMapping("/updateBook")
    public Result<Integer> updateBook(BookInfo bookInfo) {
        return Result.success(bookInfoService.updateBook(bookInfo));
    }

    @RequestMapping("/queryBookById")
    public Result<BookInfo> queryBookById(Integer bookId) {
        System.out.println("根据ID查书了！"+bookId);
        BookInfo bookInfo = bookInfoService.queryBookById(bookId);
        if(bookInfo == null) {
            return Result.fail("该书不存在！");
        }
        return Result.success(bookInfo);
    }

    @RequestMapping("/batchDelete")
    public Result<Integer> batchDelete(@RequestBody List<Integer> ids) {
        if(ids == null || ids.isEmpty()) {
            return Result.fail("发生错误，选择的目标为空！");
        }

        return Result.success(bookInfoService.batchDelete(ids));
    }
}
