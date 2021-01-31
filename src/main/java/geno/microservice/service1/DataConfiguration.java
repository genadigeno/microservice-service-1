package geno.microservice.service1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;

@Configuration
public class DataConfiguration {

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.user}")
    private String user;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.driverClassName}")
    private String driverClassName;

    @Bean
    @Primary
    public DataSource dataSource(){

        /*System.out.println("url = " + url);
        System.out.println("user = " + user);
        System.out.println("password = " + password);
        System.out.println("driverClassName = " + driverClassName);*/

        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName(driverClassName);
        builder.password(password);
        builder.username(user);
        builder.url(url);
        return builder.build();
    }
}
