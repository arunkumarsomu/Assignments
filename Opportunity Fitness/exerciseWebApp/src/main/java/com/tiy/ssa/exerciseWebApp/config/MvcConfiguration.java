package com.tiy.ssa.exerciseWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
   
    @Bean
   public SpringTemplateEngine getTemplateEngine() {
       SpringTemplateEngine templateEngine = new SpringTemplateEngine();
       templateEngine.setTemplateResolver(getTemplateResolver());
       return templateEngine;
   }
   
   @Bean
   public ThymeleafViewResolver getViewResolver() {
       ThymeleafViewResolver resolver = new ThymeleafViewResolver();
       resolver.setTemplateEngine(getTemplateEngine());
       return resolver;
   }
   
   @Bean
   public SpringResourceTemplateResolver getTemplateResolver() {
   
       SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
       
       templateResolver.setPrefix("/WEB-INF/views/");
       templateResolver.setSuffix(".html");
       templateResolver.setTemplateMode("HTML5");
       templateResolver.setCacheable(false);
       return templateResolver;
   }
}