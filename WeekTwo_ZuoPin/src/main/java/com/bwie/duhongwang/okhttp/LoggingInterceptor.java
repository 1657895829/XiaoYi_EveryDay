package com.bwie.duhongwang.okhttp;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
 * 拦截器类
 */
//自定义应用拦截器
public class LoggingInterceptor implements Interceptor {
    @Override public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
//    logger.info(String.format("Sending request %s on %s%n%s",
//        request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
//    logger.info(String.format("Received response for %s in %.1fms%n%s",
//        response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        System.out.println("t2 = " + (t2-t1));
        return response;
    }
}
