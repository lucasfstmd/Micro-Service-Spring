package com.microservice.core.property;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.http.Header;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt.config")
@Getter
@Setter
@ToString
public class JWTConfiguration {
    private String loginUrl = "/login/**";

    @NestedConfigurationProperty
    private Header header = new Header();

    private int expirationToken = 3600;
    private String privateKey = "qzOGdOqvUIWKFFwialal0dt4jnwpnMn7";
    private String type = "encrypted";

    @Getter
    @Setter
    public static class Header {
        private String name = "Authorization";
        private String prefix = "Bearer ";
    }

}
