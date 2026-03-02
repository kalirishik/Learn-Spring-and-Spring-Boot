package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
//        System.out.println( "Hello World!" );
//        Student st=new Student();
//        st.show();
        Student st=(Student)context.getBean("st1");
//        st.show();
//        System.out.println(st.getAge());
//        st.setAge(23);
//        System.out.println(st.getAge());
//        System.out.println(st.getRollno());

        st.writeExam();
    }
}
