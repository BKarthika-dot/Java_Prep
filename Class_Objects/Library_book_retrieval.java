/*1. Digital Library System
Design a system where:
Book is a class with attributes (title, author, price).
You need an array of Book objects representing a library shelf.
Some books are E-Books and should have an extra attribute (fileSizeMB).

Write a method to:

Overload a function search() to find books either by title or by author.
Use overriding so that EBook’s toString() prints different info compared to normal Book.

👉 Concepts: array of objects, inheritance, overloading, overriding. */
import java.util.Scanner;
class Book{
    String author,name;
    double price;
    String name_check;
    double price_check;

    Book(String name,String author,double price){
        this.name=name;
        this.author=author;
        this.price=price;
    }
    boolean search(String name_check){
        if(name_check.equals(name)){
            System.out.println("Title: "+name+" Author: "+author+" Price: Rs."+price);
            return true;
        }
        else{
            return false;
        }
    }
    boolean search(double price_check){
        if(price_check==price){
            System.out.println("Title: "+name+" Author: "+author+" Price: Rs."+price);
            return true;
        }
        else{
            return false;
        }
    }
}
class Ebook extends Book{
    int fileSize;
    String name_check;
    Ebook(String name,String author,double price,int fileSize){
        super(name,author,price);
        this.fileSize=fileSize;
    }
    boolean search(String name_check){
        if(name_check.equals(name)){
            System.out.println("Title: "+name+" Author: "+author+" Price: Rs."+price+" File Size: "+fileSize+"MB");
            return true;
        }
        else{
            return false;
        }
    }
}
class Book_Retrieval{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of books:\n");
        int n=sc.nextInt();
        sc.nextLine();
        Book [] book=new Book[n];
        for(int i=0;i<n;i++){
            System.out.printf("is book %d an ebook(yes/no)\n",i+1);
            String type=sc.nextLine();

            System.out.printf("enter title for book %d\n",i+1);
            String name=sc.nextLine();

            System.out.printf("enter author name for book %d\n",i+1);
            String author=sc.nextLine();

            System.out.printf("enter price for book %d\n",i+1);
            double price=sc.nextDouble();
            sc.nextLine();

            if("no".equalsIgnoreCase(type)){
                book[i]=new Book(name,author,price);
            }
            else if("yes".equalsIgnoreCase(type)){
                System.out.printf("enter file size ebook %d\n",i+1);
                int fileSize=sc.nextInt();
                sc.nextLine();
                book[i]=new Ebook(name,author,price,fileSize);
            }
        }
        System.out.println("enter value to be searched(stringdouble)");
        String input=sc.nextLine();

        int found=0;

        for(int i=0;i<n;i++){
            try{
                double doubleVal=Double.parseDouble(input);
                if(book[i].search(doubleVal)){
                    found=1;
                }
            }catch(NumberFormatException e){
                if(book[i].search(input)){
                    found=1;
                }
            }
        }
        if(found==0){
            System.out.println("sorry not found");
        }
        
    }
}
