package com.intuiture.qm.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.intuiture.qm")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public VelocityConfigurer velocityConfig() {
		VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
		velocityConfigurer.setResourceLoaderPath("/WEB-INF/velocity/");
		return velocityConfigurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		VelocityViewResolver viewResolver = new VelocityViewResolver();

		viewResolver.setViewClass(VelocityView.class);
		viewResolver.setCache(true);
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeSpringMacroHelpers(true);

		registry.viewResolver(viewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(5242880);// 5MB

		// You may also set other available properties.

		return resolver;
	}
}