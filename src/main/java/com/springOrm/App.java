package com.springOrm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springOrm.dao.StudentDao;
import com.springOrm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
       while(true) {
    	   System.out.println("PRESS 1 : Add New Student");
           System.out.println("PRESS 2 : Get Detail of one Student");
           System.out.println("PRESS 3 : Display All Student");
           System.out.println("PRESS 4 : Delete Student");
           System.out.println("PRESS 5 : Update Student");
           System.out.println("PRESS 6 : Exit");
           
           try {
			
        	   int input = Integer.parseInt(br.readLine());
        	   if(input == 1) {
        		   System.out.println("Add Student Details");
        		   System.out.println("Enter userId : ");
        		   int uid = Integer.parseInt(br.readLine());
        		   System.out.println("Enter user name : ");
        		   String uName = br.readLine();
        		   System.out.println("Enter user city : ");
        		   String uCity = br.readLine();
        		   Student s = new Student();
        		   s.setId(uid);
        		   s.setName(uName);
        		   s.setCity(uCity);
        		   int insert = studentDao.insert(s);
        
        			   System.out.println("Student Added Successfully..");
        	
        		   System.out.println("************************************\n");
        		   
        		   
        	   }else if(input == 2) {
        		   
        		   System.out.println("Enter Student id : ");
        		   int userId = Integer.parseInt(br.readLine());
        		   Student student = studentDao.getStudent(userId);
        		   System.out.println(student);
        		   System.out.println("_____________________________________________________________________________\n");
        		   
        	   }else if(input == 3) {
        		   System.out.println("All Available Students");
        		   List<Student> allStudent = studentDao.getAllStudent();
        		   for (Student student : allStudent) {
					System.out.println(student);
				   System.out.println("_____________________________________________________________________________\n");
				}
        		   
        		   
        	   }else if(input == 4) {
        		   System.out.println("Enter Student id : ");
        		   int id = Integer.parseInt(br.readLine());
        		   studentDao.deleteStudent(id);
        		   System.out.println("User deleted successfully");
        		   System.out.println("_____________________________________________________________________________\n");
        	   }else if(input == 5) {
        		   
        		   System.out.println("Update Student Details");
        		  
        		   System.out.println("Enter Student id : ");
        		   int userId = Integer.parseInt(br.readLine());
        		   Student student = studentDao.getStudent(userId);
        		   System.out.println(student);
        		   System.out.println("Enter User detail for the update : ");
        		   System.out.println("Enter user name : ");
        		   String uName = br.readLine();
        		   System.out.println("Enter user city : ");
        		   String uCity = br.readLine();
        		   
        		   student.setName(uName);
        		   student.setCity(uCity);
        		   
        		   studentDao.updateStudent(student);
        		   System.out.println("User updated successfully");
        		   System.out.println("************************************\n");
        		   
        		   
        	   }else if(input == 6) {
        		   System.out.println("ThankYou So Much For Using My Application..");
        		   System.out.println("See You Soon...");
        		   break;
        	   }
        	   
        	   
        	   
		} catch (Exception e) {
			System.out.println("Invalid Input..... Try Again");
			System.out.println(e.getMessage());
		}
       }
        
        
        
        
        
        
        
        
        
        
//        Student student =new Student(200,"Deepak Kumar", "Mdhubagan");
//        int r = studentDao.insert(student);
//        System.out.println(r);
    }
}
