package cn.edw.boottemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lianchen.zhang
 */
@Configuration
public class WebConfig {

    /**
     * 过滤器方式跨域配置，webflux模式下配置
     */
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //允许哪些头跨域
        corsConfiguration.addAllowedHeader("*");
        //允许哪些请求方式跨域
        corsConfiguration.addAllowedMethod("*");
        //允许哪些请求来源跨域
        //corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedOriginPattern("*");

        //是否允许携带cookie跨域，为false则跨域丢失cookie
        corsConfiguration.setAllowCredentials(true);
        //预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
        corsConfiguration.setMaxAge(3600L);
        //任意路径都配置跨域
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }

    /**
     * Web全局配置跨域
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowCredentials(true)
                        .allowedOriginPatterns("*")
                        .maxAge(3600);
            }
        };
    }
}
