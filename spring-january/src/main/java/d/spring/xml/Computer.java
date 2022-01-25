package d.spring.xml;

import java.util.List;

public class Computer
{
    private CPU cpu ;
    private List<Memory> memoryList;
    private Screen screen;
    private List<Storage> storageList;


    public Computer(CPU cpu)
    {
        this.cpu= cpu;
    }

    public Computer(List<Memory> memoryList)
    {
        this.memoryList =memoryList;
    }

    public Computer(CPU cpu,List<Memory> memoryList)
    {   this.cpu=cpu;
        this.memoryList =memoryList;

    }

    public Computer(List<Memory> memoryList, List<Storage> storageList) {
        this.memoryList = memoryList;
        this.storageList = storageList;
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

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Storage> getStorageList() {
        return storageList;
    }
}
