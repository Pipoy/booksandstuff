package com.mindteck.booksandstuff.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.mindteck.booksandstuff.controller",
		"com.mindteck.booksandstuff.rest" })
public class WebConfig extends WebMvcConfigurerAdapter {
	//"com.anthony.librarymanagement.validator",
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}


	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message");
		return source;
	}

	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//       registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
//       registry.addResourceHandler("/img/**").addResourceLocations("/img/**");
//       registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
//       registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/**");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
