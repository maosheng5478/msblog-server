package com.ms.blogserver.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 文件工具类
 * @author: zhh
 * @time: 2021/6/9
 */
public class FileUtils {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    public static final String NAME = "FILE_NAME";
    public static final String TIME = "FILE_NAME";

    public static List<Map<String,List<String>>> files(File directory) throws Exception {
        Map<String,List<String>> name = new HashMap<>();
        Map<String,List<String>> time = new HashMap<>();
        List<String> nameList = new ArrayList<>();
        List<String> timeList = new ArrayList<>();
        File[] listFiles = directory.listFiles();

        for (File f : listFiles) {
            if (f.isDirectory()) {
                files(f); //存在最终的节点
            } else {
                System.out.println(f.getName() + "-" + getTime(f.lastModified()));
                nameList.add(f.getName());
                timeList.add(getTime(f.lastModified()));
            }
        }
        name.put(NAME,nameList);
        time.put(TIME,timeList);
        return new ArrayList<>(Arrays.asList(name,time));
    }

    public static String getTime(long time) {
        Date d = new Date(time);
        return format.format(d);
    }

}
