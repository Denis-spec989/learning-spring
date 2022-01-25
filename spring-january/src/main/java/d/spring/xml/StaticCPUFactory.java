package d.spring.xml;

public class StaticCPUFactory {

    public static CPU createCPU(String name){
        if ("intel".equalsIgnoreCase(name)){
            return new IntelCPU();
        } else if ("amd".equalsIgnoreCase(name)){
            return new AmdCPU();
        }
        return () -> "Default";
    }
}
