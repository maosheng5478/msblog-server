package com.ms.blogserver.constant.exception;

import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.constant.result.ResultString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 错误页面
 * @author: z
 * @time: 2021/5/14
 */
@RestController
@Slf4j
public class ErrController implements ErrorController {

//    @Autowired
//    private BasicErrorController basicErrorController;
    /**
     * 404页面
     */
    @RequestMapping("/error")
    public Result handlerError(){
        log.warn(ResultCode.NOT_FOUND.CODE+":"+ResultString.PAGE_NO_FOUND.DATA);
        return ResultFactory.buildResult(ResultCode.NOT_FOUND, ResultString.PAGE_NO_FOUND.DATA);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
