/*💳 Payment System (Java Interfaces)

This project demonstrates Java interfaces, inheritance, and polymorphism through a simple bank payment system:

Payment → common interface for all payment methods (pay(), getDetails()).

Deduction → extended interface for credit cards with deductPenalty().

CreditCardPayment → pays, applies penalty if balance < 5000, masks card number.

UPIpayment → pays, masks UPI ID.

Polymorphism: All payment methods stored in a single Payment[] array.

Encapsulation: Sensitive details masked, balance handled internally.*/


import java.util.Scanner;

interface Payment{
    void pay(double payAmount);
    void getDetails();
}
interface Deduction extends Payment{
    void deductPenalty();
}
class CreditCardPayment implements Deduction{
    String cardNum;
    double balance;
    double payAmount;
    CreditCardPayment(String cardNum,double balance){
        this.cardNum=cardNum;
        this.balance=balance;
    }
    public void pay(double payAmount){
        balance=balance-payAmount;
    }
    public void deductPenalty(){
        if(balance<5000){
            balance=balance-100;
        }
    }
    public void getDetails(){
        String mask="****"+cardNum.substring(cardNum.length()-4);
        System.out.println("Card Number: "+mask);
        System.out.println("Account balance: Rs."+balance);
    }
}
class UPIpayment implements Payment{
    String UPIid;
    double balance;
    double payAmount;

    UPIpayment(String UPIid,double balance){
        this.UPIid=UPIid;
        this.balance=balance;
    }
    public void pay(double payAmount){
        balance=balance-payAmount;
    }
    public void getDetails(){
        String mask="****"+UPIid.substring(UPIid.length()-4);
        System.out.println("UPI id: "+mask);
        System.out.println("Account balance: Rs."+balance);
    }

}
class Payment_System{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of payment methods:");
        int n=sc.nextInt();
        sc.nextLine();
        Payment [] p=new Payment [n];
        for(int i=0;i<n;i++){
            System.out.printf("Is method %d CreditCard or UPI?\n",i+1);
            String type=sc.nextLine();
            if("creditcard".equalsIgnoreCase(type)){
                System.out.println("Enter card number");
                String cardNum=sc.nextLine();
                System.out.println("Enter balance");
                double balance=sc.nextDouble();
                System.out.println("Enter amount to be payed");
                double payAmount=sc.nextDouble();
                sc.nextLine();

                CreditCardPayment ccp=new CreditCardPayment(cardNum,balance);
                ccp.pay(payAmount);
                ccp.deductPenalty();
                p[i]=ccp;
                
            }
            else if("upi".equalsIgnoreCase(type)){
                System.out.println("Enter upi id");
                String UPIid=sc.nextLine();
                System.out.println("Enter balance");
                double balance=sc.nextDouble();
                System.out.println("Enter amount to be payed");
                double payAmount=sc.nextDouble();
                sc.nextLine();
                UPIpayment upi=new UPIpayment(UPIid,balance);
                upi.pay(payAmount);
                p[i]=upi;
            }
            else{
                System.out.println("invalid option");
                p[i]=null;
            }
        }
        System.out.println("----Bank Records----");
        for(int i=0;i<n;i++){
            if(p[i]!=null){
                p[i].getDetails();
            }
        }
    }
}