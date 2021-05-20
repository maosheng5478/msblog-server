package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@TableName(value = "ms_user")
public class User {

    @TableId(type = IdType.ID_WORKER)
    private Long id ;
    private String username;
    private String pwd;
    private Integer phone;
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

    public User(long id, String username, String pwd, Integer phone, String email, LocalDateTime  create_time, LocalDateTime  update_time, int version, int deleted) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
        this.createTime = create_time;
        this.updateTime = update_time;
        this.version = version;
        this.deleted = deleted;
    }

}
