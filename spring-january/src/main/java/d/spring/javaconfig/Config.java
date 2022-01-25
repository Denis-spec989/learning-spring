package d.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class Config
{
    @Bean("MyComputer")
    public Computer computer()
    {
        Computer c = new Computer();
        c.setCpu(intel());
        c.setMemoryList(List.of(sony(),kingston(),sony()));
        return c;
    }
    @Bean
    public CPU intel(){
        return new IntelCPU();
    }
    @Bean
    public CPU amd()
    {
        return new AmdCPU();
    }
    @Bean
    @Scope("prototype")
    public Memory sony(){
        return new SonyMemory();
    }
    @Bean
    public Memory kingston(){
        return new KingstonMemory();
    }

}
