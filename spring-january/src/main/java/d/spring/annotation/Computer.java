package d.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("myNewComputer")
public class Computer
{
    private CPU cpu ;
    private List<Memory> memoryList;

    @Autowired
    public Computer(@Qualifier("intelCPU") CPU cpu,@Qualifier("memoryList") List<Memory> memoryList)
    {
        this.cpu=cpu;
        this.memoryList =memoryList;

    }

    public CPU getCpu()
    {
        return cpu;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }


}
