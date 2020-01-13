package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration	// 해당 클래스를 Bean 구성 Class 임을 알려주는 것
@EnableWebMvc	//annotation 기반의 SpringMvc 구성시 필요한 Bean 설정을 자동으로 해준다
@ComponentScan({"com.example"}) // 스캔은 기본 패키지에서 시작하여 모든 컨트롤러, 리포지토리, 서비스, Bean 등을 등록합니다.
public class MvcConfig implements WebMvcConfigurer{
 
	// 서블릿 핸들러를 위한 설정
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	 
    @Bean
    public InternalResourceViewResolver viewResolver(){
             InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
             viewResolver.setViewClass(JstlView.class);
             viewResolver.setPrefix("/WEB-INF/views/");
             viewResolver.setSuffix(".jsp");
             return viewResolver;
     }


   /**
    * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
    */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
     }

}
