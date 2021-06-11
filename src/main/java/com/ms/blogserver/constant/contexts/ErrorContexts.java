package com.ms.blogserver.constant.contexts;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/10
 */
public interface ErrorContexts {

    String UNKNOWN_ERR = "未知错误";

    String FILE_ERR = "文件读取异常";

    String NO_FILE = "文件不存在";

    String FILE_NO_DELETE = "文件无法删除，需要管理员权限或尝试关闭文件";
}
