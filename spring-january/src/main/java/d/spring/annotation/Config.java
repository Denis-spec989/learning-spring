package d.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@ComponentScan("d.spring.annotation")
public class Config
{
    @Bean
    public List<Memory> memoryList(){
        return List.of(new SonyMemory(), new KingstonMemory(), new SonyMemory());
    }
    
}
