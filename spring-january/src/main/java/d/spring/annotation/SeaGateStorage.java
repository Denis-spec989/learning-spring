package d.spring.annotation;

public class SeaGateStorage implements Storage {

    @Override
    public String getVendor() {
        return "Seagate";
    }
}
