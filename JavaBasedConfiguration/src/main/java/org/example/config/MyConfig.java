package org.example.config;//package org.example.config;
//
//import org.example.Pen;
//import org.example.Pencil;
//import org.example.Student;
//import org.example.Writer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//public class MyConfig {
////    @Bean
////    public Student student(){
////        return new Student();
////    }
//
////    @Bean(name="s1")  // specific bean name
////    public Student student(){
////        return new Student();
////    }
//
//    // default scope is singleton
//
////    @Bean
////    @Scope("singleton")  // manage same bean
////    public Student student(){
////        return new Student();
////    }
//
////    @Bean
////    @Scope("prototype")  // manage different bean
////    public Student student(){
////        return new Student();
////    }
//
////    @Bean
////    public Student student(){
//////        return new Student();
////        Student st=new Student();
////        st.setRollno(12);
////        st.setWriter(pen());
////        return st;
////    }
//
////    @Bean
////    public Student student(@Autowired Writer writer){
////        Student st=new Student();
////        st.setRollno(12);
////        st.setWriter(writer);
////        return st;
////    }
//
//    @Bean
//    public Student student(@Qualifier("pen") Writer writer){    // qualifier mention what needs to choose
//                                                                // even though it have primary bean
//        Student st=new Student();
//        st.setRollno(12);
//        st.setWriter(writer);
//        return st;
//    }
//
//    @Bean
//    public Pen pen(){
//        return new Pen();
//    }
//
//    @Bean
//    @Primary
//    public Pencil pencil(){
//        return new Pencil();
//    }
//}


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class MyConfig{

}