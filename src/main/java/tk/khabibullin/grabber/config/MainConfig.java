package tk.khabibullin.grabber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MainConfig {
    @Bean
    public RestTemplate getRestClient() {
        return new RestTemplate();
    }
}
