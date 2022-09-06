package com.emo.mybatis.interceptor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author sherxia92
 */
@Slf4j
@Data
@Intercepts({
        @Signature(type = Executor.class,
                method ="query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }
        ),
        @Signature(type = Executor.class,
                method ="query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
        ),
        @Signature(type = ParameterHandler.class, // 确定要拦截的对象
                method = "setParameters", // 确定要拦截的方法
                args = { PreparedStatement.class } // 拦截方法的参数
        )
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
