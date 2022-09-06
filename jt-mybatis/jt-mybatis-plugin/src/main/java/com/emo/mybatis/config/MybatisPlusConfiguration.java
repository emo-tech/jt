package com.emo.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.emo.mybatis.interceptor.PrintInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author sherxia92
 */
@Configuration
public class MybatisPlusConfiguration {

    @Bean
    public PrintInterceptor printInterceptor() {
        return new PrintInterceptor();
    }

    /**
     * 批量处理时间问题
     * @return
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            //自动添加
            @Override
            public void insertFill(MetaObject metaObject) {
                //第二参数要和实体类中字段名一致，第三个参数字段类型要和实体类中字段类型一致，最后一个参数是待填入的数据
                this.strictInsertFill(metaObject, "createdDate", Timestamp.class, Timestamp.valueOf(LocalDateTime.now()));
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                //第二参数要和实体类中字段名一致，第三个参数字段类型要和实体类中字段类型一致，最后一个参数是待填入的数据
                this.strictInsertFill(metaObject, "createdDate", Timestamp.class, Timestamp.valueOf(LocalDateTime.now()));
            }
        };
    }
}
