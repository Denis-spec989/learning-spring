package d.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class Config
{
    @Bean()
    public Computer computer()
    {
        Computer c = new Computer();
        c.setCpu(amd());
        c.setMemoryList(List.of(sony(),kingston(),sony()));
        c.setScreen(philips());
        c.setStorageList(List.of(seagate(),seagate()));
        return c;
    }
  @Bean
  public CPU intel()
  {
      return new IntelCPU();
  }
  @Bean
  public CPU amd()
  {
      return new AmdCPU();
  }
  @Bean
  public Memory sony()
  {
      return new SonyMemory();
  }
  @Bean
    public Memory kingston()
  {
      return new KingstonMemory();
  }
  @Bean
    public Screen dell()
  {
      return new DellScreen();
  }
  @Bean
  public Screen philips()
  {
      return new PhilipsScreen();
  }
  @Bean
    public Storage seagate()
  {
      return new SeaGateStorage();
  }
    @Bean
    public Storage wd()
    {
        return new WDStorage();
    }

}
