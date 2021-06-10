package com.ms.blogserver.controller;

import com.ms.blogserver.config.exception.CustomException;
import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.dto.BaseDTO;
import com.ms.blogserver.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/10
 */
@RestController
@Slf4j
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private FileService fileService;

    @GetMapping(value = "/find/list")
    public Result getAllLog(BaseDTO dto) {
        try {
            return ResultFactory.buildSuccessResult(fileService.findFileName(dto));
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @PostMapping(value = "/get/context")
    public Result getLog(String fileName) {
        try {
            return ResultFactory.buildSuccessResult(fileService.getLog(fileName));
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @PostMapping(value = "/delete")
    public Result deleteLog(String fileName) {
        try {
            fileService.deleteFile(fileName);
            return ResultFactory.buildSuccessResult("");
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}
