package d.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("d.spring.annotation")
public class Config {

    @Bean
    public List<Memory> memoryList(){
        return List.of(new SonyMemory(), new KingstonMemory(), new KingstonMemory());
    }
    @Bean
    public List<Storage> storageList()
    {
        return List.of(new SeaGateStorage(),new SeaGateStorage());
    }

}
