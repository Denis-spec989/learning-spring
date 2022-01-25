package d.spring.javaconfig;

import java.util.List;

public class Computer
{
    private CPU cpu ;
    private List<Memory> memoryList;

    public Computer(CPU cpu)
    {
        this.cpu= cpu;
    }
    public Computer(){}

    public Computer(List<Memory> memoryList)
    {
        this.memoryList =memoryList;
    }
    public Computer(CPU cpu, List<Memory> memoryList)
    {   this.cpu=cpu;
        this.memoryList =memoryList;

    }

    public CPU getCpu()
    {
        return cpu;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }

    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
}
