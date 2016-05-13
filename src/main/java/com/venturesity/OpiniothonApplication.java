package com.venturesity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource( value = { "classpath:application.properties" } )
public class OpiniothonApplication {

    // private static final Logger LOG =
    // LoggerFactory.getLogger(Application.class);

    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(OpiniothonApplication.class, args);
    }

    
   
}
