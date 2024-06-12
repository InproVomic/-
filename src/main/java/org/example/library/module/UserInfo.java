package org.example.library.module;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    // id | user_name | password | delete_flag | create_time | update_time
    private int id;
    private String username;
    private String password;
    private int deleteFlag;
    private Date createTime;
    private Date updateTime;
}
