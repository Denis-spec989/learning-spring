package d.spring.javaconfig;

public class AmdCPU implements CPU
{

    @Override
    public String getVendor() {
        return "AMD";
    }
}
