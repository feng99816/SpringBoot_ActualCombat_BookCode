package xyz.alifenga.config;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 示例拦截器
 * 可通过实现HanlderInterceptor接口或继承HandlerInterceptorAdapter来实现自定义拦截器
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    /**
     * 重写preHandle方法,在请求发生前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    /**
     * 重写postHandle方法,在请求完成后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long time = System.currentTimeMillis() - startTime;
        System.out.println(request.getRequestURI() + "本次处理请求处理时间为:" + time + "ms");
        request.setAttribute("handlingTime", time);
    }
}
