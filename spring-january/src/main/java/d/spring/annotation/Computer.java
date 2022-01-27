package d.spring.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("myNewComputer")
public class Computer {

    private CPU cpu;
    private List<Memory> memoryList;

    private Screen screen;
    private List<Storage> storageList;




    @Autowired
    public Computer(@Qualifier("amd") CPU cpu,@Qualifier("memoryList")List<Memory> memoryList,
                    @Qualifier("dell") Screen screen,@Qualifier("storageList") List<Storage> storageList){
        this.cpu = cpu;
        this.memoryList = memoryList;
        this.screen=screen;
        this.storageList = storageList;
    }

    public CPU getCpu() {
        return cpu;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }

    public Screen getScreen() {
        return screen;
    }

    public List<Storage> getStorageList() {
        return storageList;
    }
}
