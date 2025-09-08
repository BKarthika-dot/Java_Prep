// Hospital Patient Management System
// Uses an abstract Patient class with subclasses InPatient and OutPatient.
// Demonstrates ArrayList with objects, abstract methods, and runtime polymorphism.
// Menu-driven program to add patients and display their details.
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Patient{
    String name;
    int age;
    Patient(String name,int age){
        this.name=name;
        this.age=age;
    }
    abstract void displayInfo();
}

class InPatient extends Patient{
    int roomNumber,daysAdmitted;
    InPatient(String name,int age,int roomNumber,int daysAdmitted){
        super(name,age);
        this.roomNumber=roomNumber;
        this.daysAdmitted=daysAdmitted;
    }
    public void displayInfo(){
        System.out.println("---Patient Details---");
        System.out.println("Name: "+name+" Age: "+age+" Room Number: "+roomNumber+" Days Admitted: "+daysAdmitted);
    }
}
class OutPatient extends Patient{
    String appointmentDate;
    OutPatient(String name,int age,String appointmentDate){
        super(name,age);
        this.appointmentDate=appointmentDate;
    }
    public void displayInfo(){
        System.out.println("---Patient Details---");
        System.out.println("Name: "+name+" Age: "+age+" Appointment Date: "+appointmentDate);
    }
}
class Hospital_management{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        ArrayList <Patient> patients =new ArrayList<> ();

        System.out.println("Enter 1 to add Inpatients, 2 for Outpatients and 3 to exit program");

        while(true){
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                String name=sc.nextLine();
                int age=sc.nextInt();
                int roomNumber=sc.nextInt();
                int daysAdmitted=sc.nextInt();
                sc.nextLine();

                Patient p=new InPatient(name, age, roomNumber, daysAdmitted);
                patients.add(p);
                System.out.println("Inpatient added successfully!");
            }
            else if(choice==2){
                String name=sc.nextLine();
                int age=sc.nextInt();
                sc.nextLine();
                String appointmentDate=sc.nextLine();

                Patient p=new OutPatient(name, age, appointmentDate);
                patients.add(p);
                System.out.println("Outpatient added successfully!");
            }
            else if(choice==3){
                break;
            }
        }

        System.out.println("------All Patients------");
        for(Patient p:patients){
            p.displayInfo();
        }


    }
}