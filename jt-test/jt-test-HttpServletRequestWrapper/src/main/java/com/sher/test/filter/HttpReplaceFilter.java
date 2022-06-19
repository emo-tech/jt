package com.sher.test.filter;

import com.sher.test.serlvet.BodyRequestWrapper;
import com.sher.test.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author sherxia92
 */
@Slf4j
@WebFilter(filterName = "httpReplaceFilter", urlPatterns = "/*")
//@Component
public class HttpReplaceFilter implements Filter {

    @Autowired
    private FooService fooService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        String contentType = httpServletRequest.getContentType();
        if (!StringUtils.isEmpty(contentType)) {
            contentType = contentType.toLowerCase();
        }
        log.debug("method: [{}]", method);
        log.debug("contentType: [{}]", contentType);
        if (HttpMethod.POST.toString().equals(method) && !StringUtils.isEmpty(contentType) && contentType.contains(MediaType.APPLICATION_JSON_VALUE)) {
            servletRequest = new BodyRequestWrapper(httpServletRequest);
        }
        chain.doFilter(servletRequest, servletResponse);
    }
}
