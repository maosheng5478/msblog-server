package com.ms.blogserver.constant.contexts;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/9
 */
public interface URLContexts {

    //日志存储的相对路径，用于linux正式环境
    String log_relative_url = "spring-log/ms-server/";

    //日志存储绝对路径，开发环境（windows环境）
    String log_absolute_url = "D:/myself/IdeaProject/spring-log/ms-server/";
}
