package d.spring.javaconfig;

public class SeaGateStorage implements Storage {

    @Override
    public String getVendor() {
        return "Seagate";
    }
}
