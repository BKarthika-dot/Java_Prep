/*
   University Course Enrollment System
   -----------------------------------
   Create an abstract class `Course` with subclasses `TheoryCourse` and `LabCourse`.
   - Demonstrates abstract classes, static members, constructor overloading, and 
     conversion constructors.
   - Uses an array of abstract class references to store both theory and lab courses.
   - Allows adding different types of courses via user input and calculates total 
     courses enrolled.
*/

import java.util.Scanner;

abstract class Course{
    String courseName;
    int credits;
    static int totalCourses;

    Course(String courseName,int credits){
        this.courseName=courseName;
        this.credits=credits;
    }
    abstract void displayCourse();

    static void displayTotalCourses(){
        System.out.println("Total Courses Enrolled: "+totalCourses);
    }

}
class TheoryCourse extends Course{
    int numLectures;
    TheoryCourse(String courseName,int credits,int numLectures){
        super(courseName,credits);
        this.numLectures=numLectures;
    }
    TheoryCourse(String courseName,int credits){
        super(courseName,credits);
        this.numLectures=10;
    }

    public void displayCourse(){
        System.out.println("Theory Course: " + courseName + " Credits: " + credits + " Lectures: " + numLectures);
    }
    
}

class LabCourse extends Course{
    int numExperiments;
    
    LabCourse(String courseName,int credits,int numExperiments){
        super(courseName,credits);
        this.numExperiments=numExperiments;
    }

    LabCourse(TheoryCourse theoryLab){
        super(theoryLab.courseName,theoryLab.credits);
        this.numExperiments=theoryLab.credits;
    }

    public void displayCourse(){
        System.out.println("Lab Course: " + courseName + " Credits: " + credits + " Experiments: " + numExperiments);
    }
}
class University_Course_Enrollment{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter 1 for optional theory course , 2 for fixed theory course ,3 for lab course,4 to exit program");
        Course [] courses=new Course [25];
        for(int i=0;i<25;i++){
            System.out.println("enter choice");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.println("enter course name");
                String courseName=sc.nextLine();
                System.out.println("enter total no of credits");
                int credits=sc.nextInt();
                System.out.println("enter no of lectures");
                int numLectures=sc.nextInt();
                sc.nextLine();
                TheoryCourse t = new TheoryCourse(courseName, credits, numLectures);
                courses[i]=t;
                courses[++i]=new LabCourse(t);
                Course.totalCourses+=2;
            }
            else if(choice==2){
                System.out.println("enter course name");
                String courseName=sc.nextLine();
                System.out.println("enter total no of credits");
                int credits=sc.nextInt();
                sc.nextLine();
                TheoryCourse t=new TheoryCourse(courseName, credits);
                courses[i]=t;
                courses[++i]=new LabCourse(t);
                Course.totalCourses+=2;
            }
            else if(choice==3){
                System.out.println("enter course name");
                String courseName=sc.nextLine();
                System.out.println("enter total no of credits");
                int credits=sc.nextInt();
                System.out.println("enter total no of experiments");
                int numExperiments=sc.nextInt();
                sc.nextLine();
                courses[i]=new LabCourse(courseName, credits, numExperiments);
                Course.totalCourses++;
            }
            else if(choice==4){
                break;
            }
            else{
                courses[i]=null;
                System.out.println("Invalid");
            }
        }
        for(int i=0;i<25;i++){
            if(courses[i]!=null){
                courses[i].displayCourse();
            }
        }

        Course.displayTotalCourses();
        sc.close();
    }
}