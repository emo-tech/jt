package com.emo.mybatis.interceptor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author sherxia92
 */
@Slf4j
@Data
@Intercepts({
        @Signature(type = Executor.class, method ="query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }),

})
public class PrintInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("intercept start....");
        Object obj = invocation.proceed();
        log.info("intercept end....");
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
