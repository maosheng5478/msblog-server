package com.ms.blogserver.config.mybatis.plus;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
@MapperScan("com.ms.blogserver.mapper")
public class MyBatisConfig {

    /**
     * 添加乐观锁插件
     * mybatis-plus 3.3version
     * 旧版本使用 new OptimisticLockerInterceptor();
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 乐观锁
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 添加乐观锁到插件中
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;

    }
    /**
     * 逻辑删除插件
     *
     */
    //@Bean
    //public ISqlInjector sqlInjector() {
    //    return new LogicSqlInjector();
    //}

}
