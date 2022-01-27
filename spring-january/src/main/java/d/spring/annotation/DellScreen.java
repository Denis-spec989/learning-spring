package d.spring.annotation;

import org.springframework.stereotype.Component;

@Component("dell")
public class DellScreen implements Screen {
    @Override
    public String getVendor() {
        return "Dell";
    }
}
