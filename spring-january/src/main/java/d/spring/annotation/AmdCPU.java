package d.spring.annotation;

public class AmdCPU implements CPU
{

    @Override
    public String getVendor() {
        return "AMD";
    }
}
