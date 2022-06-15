package pl.jarekwasowski.windsurfering;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class WebConfiguration {

    private static final String contactName = "JW";
    private static final String contactUrl = "http://localhost/";
    private static final String contactEmail = "wasowski.jarek@gmail.com";
    private static final String title = "App";
    private static final String description = "Nice app";
    private static final String version = "0.0.1";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.jarekwasowski"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/v1.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title(title).description(description).version(version)
                .contact(new Contact(contactName, contactUrl, contactEmail)).build();
    }


}
