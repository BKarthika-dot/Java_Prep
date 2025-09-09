/*
Question Summary:
Implement a Gym Membership Management system using classes and objects.

Requirements:
1. Create a Member class with attributes: name, membershipType, and fee.
2. Use an ArrayList to store multiple members.
3. Add a static variable to keep track of total members enrolled.
4. Implement a copy constructor in Member:
   - Used when a member joins via referral.
   - Referral members get 50% discount on the fee.
5. Create a main class (Gym_Membership) to:
   - Allow users to enroll members as 'monthly', 'yearly', 
     'monthly referral', or 'yearly referral'.
   - Store members in the ArrayList.
   - Display details of all members and the total number of members at the end.

Concepts Used:
- Classes and Objects
- ArrayList
- Static Members
- Copy Constructor
- User Input (Scanner)
*/


import java.util.Scanner;
import java.util.ArrayList;

class Member{
    String name;
    String membershipType;
    double fee;
    Member(String name,String membershipType,double fee){
        this.name=name;
        this.membershipType=membershipType;
        this.fee=fee;
    }
    static int totalMembers=0;
    Member(Member m){
        this.name=m.name;
        this.membershipType=m.membershipType;
        this.fee=(m.fee)/2;
    }
    void display(){
        System.out.println("Name: "+name+" Membership: "+membershipType+" Fee: Rs."+fee);
    }
}

class Gym_Membership{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        ArrayList<Member> members=new ArrayList<> ();

        
        System.out.println("enter membership type 'monthly' , 'yearly', 'monthly referral' or 'yearly referral'.enter 'done' to end program");
        while (true) {
            System.out.print("Enter membership type: ");
            String membershipType = sc.nextLine();

            if ("done".equalsIgnoreCase(membershipType)) {
                break;
            }

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            if ("monthly".equalsIgnoreCase(membershipType)) {
                Member m = new Member(name, "Monthly", 2500.00);
                members.add(m);
                Member.totalMembers++;
            } 
            else if ("yearly".equalsIgnoreCase(membershipType)) {
                Member m = new Member(name, "Yearly", 9000.00);
                members.add(m);
                Member.totalMembers++;
            } 
            else if ("monthly referral".equalsIgnoreCase(membershipType)) {
                Member original = new Member(name, "Monthly", 2500.00);
                Member referral = new Member(original); // copy constructor
                members.add(referral);
                Member.totalMembers++;
            } 
            else if ("yearly referral".equalsIgnoreCase(membershipType)) {
                Member original = new Member(name, "Yearly", 9000.00);
                Member referral = new Member(original); // copy constructor
                members.add(referral);
                Member.totalMembers++;
            } 
            else {
                System.out.println("Invalid membership type! Try again.");
            }
        }
        System.out.println("----Members Enrolled----");
        for(Member m :members){
            m.display();
        }
        System.out.println("Total Members: "+Member.totalMembers);

        sc.close();
    }
}