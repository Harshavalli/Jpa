package com.jpa.find;  
  
import javax.persistence.*;  

  
import com.jpa.student.*;
import com.jpa.student.StudentEntity;  
  
public class FindStudent {  
    public static void main(String args[])  
    {  
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("Student_details");  
        EntityManager em=emf.createEntityManager();  
          
        em.getTransaction().begin();  
        //Insertion
        StudentEntity s1=new StudentEntity();  
        s1.setS_id(110);  
        s1.setS_name("Gaurav");  
        s1.setS_age(24);  
          
        StudentEntity s2=new StudentEntity();  
        s2.setS_id(111);  
        s2.setS_name("Ronit");  
        s2.setS_age(22);  
          
        StudentEntity s3=new StudentEntity();  
        s3.setS_id(112);  
        s3.setS_name("Rahul");  
        s3.setS_age(26);  
          
        em.persist(s1);  
        em.persist(s2);  
        em.persist(s3); 
       // em.getTransaction().commit();  
  
         //Fetching 
        StudentEntity s=em.find(StudentEntity.class,103);  
          
        System.out.println("Student id = "+s.getS_id());  
        System.out.println("Student Name = "+s.getS_name());  
        System.out.println("Student Age = "+s.getS_age());
        
        //Updation
        StudentEntity ss=em.find(StudentEntity.class,102);  
        System.out.println("Before Updation");  
        System.out.println("Student id = "+ss.getS_id());  
        System.out.println("Student Name = "+ss.getS_name());  
        System.out.println("Student Age = "+ss.getS_age());  
          
ss.setS_age(30);  
          
        System.out.println("After Updation");  
        System.out.println("Student id = "+ss.getS_id());  
        System.out.println("Student Name = "+ss.getS_name());  
        System.out.println("Student Age = "+ss.getS_age());
        
        //Deletion
        StudentEntity sss=em.find(StudentEntity.class,102);  
        em.remove(sss);  
        em.getTransaction().commit();  
          
          
    }  
}  
