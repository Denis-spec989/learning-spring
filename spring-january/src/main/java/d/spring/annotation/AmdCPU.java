package d.spring.annotation;

import org.springframework.stereotype.Component;

@Component("amd")
public class AmdCPU implements CPU {
    @Override
    public String getVendor() {
        return "AMD";
    }
}
