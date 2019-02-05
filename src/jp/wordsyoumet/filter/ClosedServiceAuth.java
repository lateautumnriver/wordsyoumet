package jp.wordsyoumet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.util.logging.Logger;

import java.io.PrintWriter;

public class ClosedServiceAuth implements Filter {

    private FilterConfig filterConfig;
    private static final Logger log = Logger.getLogger(ClosedServiceAuth.class.getName());  

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        log.warning("test");
        
        response.setContentType("text/plain");
        String ctx;
        ctx = "This is a test string.";
        PrintWriter out = response.getWriter();
        out.println(ctx);

        //filterChain.doFilter(request, response);
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

}
