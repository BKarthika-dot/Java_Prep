/*
 * EmployeeDataAnalysis.java
 *
 * Demonstrates the use of Java Generics, Serialization, and File I/O
 * to manage employee data. Full-time and part-time employee details
 * are stored, serialized to files, deserialized, and analyzed to
 * compute average salaries.
 */


import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

interface Storable{
    void saveToFile(String fileName,Map<String,Double> details) throws IOException;
    void loadFromFile(String fileName) throws IOException,ClassNotFoundException;
}

abstract class Employee implements Serializable{
    String name;
    int id;
    Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    abstract double calculatePay();

    @Override
    public String toString(){
        return "ID: "+id+" Name: "+name;
    }
}

class FullTimeEmployee extends Employee{
    double monthlySalary;
    FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    double calculatePay(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    double hourlyRate,hoursWorked;
    PartTimeEmployee(String name,int id,double hourlyRate,double hoursWorked){
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    double calculatePay(){
        return hourlyRate*hoursWorked;
    }

}

class EmployeeManager<T extends Employee> implements Storable{
    ArrayList<T> employees=new ArrayList<>();
    
    void addEmployee(T emp){
        employees.add(emp);
    }
    ArrayList<T> getAllEmployees(){
        return employees;
    }
    HashMap<String,Double> salaryDetails=new HashMap<>();

    Map<String,Double> SummarizePay(){
        for(T emp: employees){
            salaryDetails.put(emp.name,emp.calculatePay());
        }

        return salaryDetails;
    }

    @Override
    public void saveToFile(String fileName,Map<String,Double> details) throws IOException {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(details);
            System.out.println("Data saved to "+fileName);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) throws IOException,ClassNotFoundException{
        try(ObjectInputStream ois =new ObjectInputStream((new FileInputStream(fileName)))){
            Map<String,Double> details=(Map<String,Double>) ois.readObject();
            System.out.println("Read data from file");
            double sum=0;
            for(double salary:details.values()){
                sum+=salary;
            }
            DecimalFormat  df=new DecimalFormat("#0.00");
            System.out.println("Average Salary: "+df.format(sum/details.size()));
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}


public class EmployeeDataAnalysis {
    public static void main(String[] args){
        EmployeeManager<FullTimeEmployee> fullTime=new EmployeeManager<>();
        EmployeeManager<PartTimeEmployee> partTime=new EmployeeManager<>();
        
        fullTime.addEmployee(new FullTimeEmployee("Latha", 101, 15000));
        fullTime.addEmployee(new FullTimeEmployee("Ravi", 102, 20000));

        partTime.addEmployee(new PartTimeEmployee("Priya", 201, 100, 12));
        partTime.addEmployee(new PartTimeEmployee("Gokul", 202, 150, 10));

        Map<String,Double> fullTimeSummary=fullTime.SummarizePay();
        Map<String,Double> partTimeSummary=partTime.SummarizePay();

        try{
            fullTime.saveToFile("FullTimeData.ser", fullTimeSummary);
            partTime.saveToFile("PartTimeData.ser", partTimeSummary);

            System.out.println("For Full Time Employees: ");
            fullTime.loadFromFile("FullTimeData.ser");

            System.out.println("For Part Time Employees: ");
            partTime.loadFromFile("PartTimeData.ser");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
