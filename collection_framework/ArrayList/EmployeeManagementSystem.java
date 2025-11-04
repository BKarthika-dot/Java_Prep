/*This program demonstrates basic employee management using Java’s Collection Framework.

ArrayList<Employee> – used to dynamically store and manage multiple employee records without worrying about fixed size like arrays.

Scanner – handles user input interactively.

Iterator – safely removes elements from the list while iterating (avoids ConcurrentModificationException).*/

import java.util.*;

class Employee{
    int id;
    String name;
    double salary;
    Employee(int id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
}
class EmployeeManagementSystem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Employee> employees=new ArrayList<>();
        while(true){
            String idInput=sc.nextLine();

            if(idInput.isEmpty()){
                break;
            }         

            int id=Integer.parseInt(idInput);
            String name=sc.nextLine();
            double salary=sc.nextDouble();
            sc.nextLine();

            Employee e=new Employee(id,name,salary);
            employees.add(e);
        }

        int id_to_remove=sc.nextInt();

        Iterator<Employee> it=employees.iterator();
        while(it.hasNext()){
            Employee e=it.next();
            if(e.id==id_to_remove){
                it.remove();
            }
        }

        System.out.printf("%-10s %-15s %-10s\n", "ID", "NAME", "SALARY");
        for(Employee e: employees){
            System.out.printf("%-10d %-15s %-10.2f\n", e.id, e.name, e.salary);
        }
    }
}
