package com.ms.blogserver.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@TableName(value = "ms_user")
public class User implements Serializable {

    @TableId(type = IdType.ID_WORKER)
    private Long id ;
    private String username;
    private String pwd;
    private String phone;
    private String introduction;
    private int sex;
    private String email;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private int version;
    @TableLogic
    private int deleted;


    public User() {
    }

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public User(String username, String pwd, String phone, String email) {
        this.username = username;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
    }
}
