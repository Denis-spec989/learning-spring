package d.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class PhilipsScreen implements Screen {
    @Override
    public String getVendor() {
        return "Philips";
    }
}
