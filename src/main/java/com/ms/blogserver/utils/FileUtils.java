package com.ms.blogserver.utils;

import com.ms.blogserver.config.exception.CustomException;
import com.ms.blogserver.constant.contexts.ErrorContexts;
import com.ms.blogserver.vo.FileSimpleVO;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 文件工具类
 * @author: zhh
 * @time: 2021/6/9
 */
@Slf4j
public class FileUtils {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String NAME = "FILE_NAME";
    public static final String TIME = "FILE_NAME";

    /**
     * 获取当前目录下所有.log文件的文件名和修改时间
     *
     * @param directory 文件目录
     * @return
     * @throws Exception
     */
    public static List<FileSimpleVO> files(File directory) throws Exception {
        File[] listFiles = directory.listFiles();
        List<FileSimpleVO> list = new ArrayList<>();
        for (File f : listFiles) {
            if (f.isDirectory()) {
                files(f); //存在最终的节点
            } else {
                if (f.getName().endsWith("log")) {
                    FileSimpleVO fileSimpleVO = new FileSimpleVO();
                    System.out.println(f.getName() + "; " + getTime(f.lastModified()));
                    fileSimpleVO.setFileName(f.getName());
                    fileSimpleVO.setTime(getTime(f.lastModified()));
                    list.add(fileSimpleVO);
                }
            }
        }
        return list;
    }

    /**
     * 文件时间格式转换
     *
     * @param time 文件修改时间
     * @return
     */
    public static String getTime(long time) {
        Date d = new Date(time);
        return format.format(d);
    }

    public static String loadLog(String url){
        try{
            File file = new File(url+".log");
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String strLine;
            StringBuffer stringBuffer = new StringBuffer();
            while ((strLine = br.readLine()) != null)   {
                stringBuffer.append(strLine);
                stringBuffer.append("\n");
            }
            fstream.close();
            return stringBuffer.toString();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new CustomException(ErrorContexts.FILE_ERR);
        }
    };
}
