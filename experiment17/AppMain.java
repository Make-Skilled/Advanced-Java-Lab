package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.AppConfig;
import com.example.dao.StudentDAO;
import com.example.model.Student;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDAO dao = context.getBean(StudentDAO.class);

        Student s1 = new Student(); s1.setId(1); s1.setName("Madhu"); s1.setAddress("Hyderabad");
        Student s2 = new Student(); s2.setId(2); s2.setName("Sravani"); s2.setAddress("Guntur");

        try {
            dao.insertAndUpdate(s1, s2);
        } catch (Exception e) {
            System.out.println("Transaction failed and rolled back: " + e.getMessage());
        }

        context.close();
    }
}
