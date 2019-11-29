package cn.clboy.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.ZuulFilterInitializer;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author cloudlandboy
 * @Date 2019/11/28 下午5:11
 * @Since 1.0.0
 */

@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 该过滤器是否生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 登陆校验逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 获取zuul提供的上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = context.getRequest();

        //从请求参数中获取token
        String token = request.getParameter("token");

        //判断是否存在token
        if (StringUtils.isNotBlank(token)) {
            // 校验通过，把登陆信息放入上下文信息，继续向后执行
            context.set("token","token");
        }else {
            // 过滤该请求，不对其进行路由
            context.setSendZuulResponse(false);
            // 设置响应状态码，401
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            // 设置响应信息
            context.setResponseBody("REQUEST UNAUTHORIZED");
        }
        return null;
    }

    /**
     * 过滤器类型
     *
     * @return
     */
    @Override
    public String filterType() {
        //前置过滤器
        return "pre";
    }

    /**
     * 过滤器的执行顺序（数值越小优先级越高）
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

}