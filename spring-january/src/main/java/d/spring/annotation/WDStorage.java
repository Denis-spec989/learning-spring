package d.spring.annotation;

public class WDStorage implements Storage {

    @Override
    public String getVendor() {
        return "WD";
    }
}
