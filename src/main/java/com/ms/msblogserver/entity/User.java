package com.ms.msblogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

import java.util.Date;

@Data
@ToString
@TableName(value = "ms-user")
public class User {

    private long id ;
    private String usernaem;
    private String pwd;
    private int phone;
    private Date create_time;
    private Date update_time;
    private String version;
    private int deleted;

    public User() {
    }

}
