package d.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;


public class AnnotationApp
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
        Computer computer = (Computer)ctx.getBean("MyComputer");
        System.out.println("CPU-"+computer.getCpu().getVendor());
        System.out.println("Memory-"+computer.getMemoryList().stream().map(Device::getVendor).collect(Collectors.joining(", ")));
    }
}
