package spring_introduction;

import org.springframework.stereotype.Component;

;

@Component
public class Dog implements Pet {
    @Override
    public void say() {
        System.out.println("Wow-wow");
    }

    public void init () {
        System.out.println("Class dog init-method");
    }

    public void destroy () {
        System.out.println("Class dog destroy-method");
    }
}
