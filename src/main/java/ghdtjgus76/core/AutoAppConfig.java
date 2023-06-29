package ghdtjgus76.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "ghdtjgus76.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  Configuration.class)
)
public class AutoAppConfig {

}
