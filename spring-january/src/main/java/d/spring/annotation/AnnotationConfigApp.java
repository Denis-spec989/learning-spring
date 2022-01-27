package d.spring.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnnotationConfigApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

        Computer computer = (Computer)ctx.getBean("myNewComputer");
        System.out.println("CPU: " + computer.getCpu().getVendor());
        System.out.println("Memory: " + computer.getMemoryList().stream().map(Device::getVendor).collect(Collectors.joining(", ")));
        System.out.println("Screen: " + computer.getScreen().getVendor());
        System.out.println("Storage: " + computer.getStorageList().stream().map(Device::getVendor).collect(Collectors.joining(", ")));

    }

}
