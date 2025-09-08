/*Create a program to manage a Student Grade System using interfaces and ArrayList.
Define an interface GradeBook with methods:
void addStudent(String name, double grade)
double calculateAverageGrade()
Define a class Student with fields: name and grade. Add a method double getGrade() that returns the grade.
Implement the GradeBook interface in a class SimpleGradeBook. Use an ArrayList<Student> to store all students.
In main, use a loop with menu options:
Add a student
Display average grade of all students
Exit */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

interface GradeBook{
    void addStudent(String name,double grade);
    double calculateAvgGrade();
}
class Student{
    String name;
    double grade;
    Student(String name,double grade){
        this.name=name;
        this.grade=grade;
    }
    double getGrade(){
        return grade;
    }
}
class SimpleGradeBook implements GradeBook{
    private List <Student> students;//students is declared as a list

    SimpleGradeBook(int student_num){
        this.students=new ArrayList<> (student_num); //this creates a resizeable array; unlike Student[] this array grows as objects are added
    }

    public void addStudent(String name,double grade){
        Student newStudent=new Student(name,grade);//everytime user adds a student an object is created for "Student" 

        students.add(newStudent); // adding the object to the list;
                                    //.add() adds that student to ArrayList

        System.out.println("Student "+name+" has been added to the system");
    }
    public double calculateAvgGrade(){
        double sum=0;
        for(Student student:students){  //note that students is the list
            sum+=student.getGrade();
        }
        if(students.size()==0){
            return 0;
        }
        return sum/students.size();
    }
}
class Student_Grade_System{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to add student details and 2 to see class average and 3 to exit program");
        

        GradeBook gb=new  SimpleGradeBook(10);

        while(true){
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                String name=sc.nextLine();
                double grade=sc.nextDouble();
                gb.addStudent(name, grade);
            }
            else if(choice==2){
                double avg=gb.calculateAvgGrade();
                System.out.println("Average: "+avg);
            }
            else if(choice==3){
                break;
            }
        }
        sc.close();
    }
}