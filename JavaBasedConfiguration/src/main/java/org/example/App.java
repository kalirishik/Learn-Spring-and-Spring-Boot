package org.example;

import org.example.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//        Student st=new Student();
//        st.show();

//        Student st = context.getBean(Student.class); // declare by class name
//        st.show();

//        Student st = (Student) context.getBean("student"); // declare by method name
//        st.show();

        // for learn scope
//        Student st1 = (Student) context.getBean("student");
//        Student st2 = (Student) context.getBean("student");
//        st.show();

        Student st = context.getBean(Student.class);
        System.out.println(st.getRollno());
        st.writeExam();

    }
}
