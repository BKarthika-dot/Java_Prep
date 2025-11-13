/*
 * SmartBoxUtility.java
 *
 * A demonstration of Java Generics and Method Overloading.
 * 
 * This program defines a generic class SmartBox<T> that can store objects 
 * of any type (Number, String, etc.) and perform type-dependent operations:
 *  - Computes the average of numeric elements.
 *  - Finds the longest word among string elements.
 *  - Uses method overloading to provide separate getMax() implementations 
 *    for numeric and string-based objects.
 * 
 * The example in main() showcases the use of both numeric and string SmartBoxes.*/
import java.util.*;
import java.text.DecimalFormat;

class SmartBox<T>{
    ArrayList<T> objects=new ArrayList<>();

    void addObject(T obj){
        objects.add(obj);
    }
    void displayObjects(){
        for(T obj: objects){
            System.out.println(obj.toString());
        }
    }
    double sum=0;
    int flag=0;
    double computeAverage(){
        for(T obj: objects){
            if(obj instanceof Number){  
                flag=1;                 //check if its a number first
                sum+=((Number)obj).doubleValue();
            }
        }
        return (flag==0)? 0: sum/objects.size();
    }
    String longestWord(){
        int max=-1;
        String word=null;
        for(T obj:objects){
            if(max<obj.toString().length()){
                max=obj.toString().length();
                word=obj.toString();
            }
        }
        return word;
    }

    double getMax(Number example){
        double max=0;
        for(T obj: objects){
            double val=((Number)obj).doubleValue();
            if(val>max){
                max=val;
            }
        }
        return max;
    }

    //overloading getMax() for string like objects
    String getMax(String example){
        int max=-1;
        String word=null;
        for(T obj:objects){
            if(max<obj.toString().length()){
                max=obj.toString().length();
                word=obj.toString();
            }
        }
        return word;
    }
}
public class SmartBoxUtility {
    public static void main(String[] args){
        SmartBox<Integer> numberSmartBox=new SmartBox<>();
        SmartBox<String> wordSmartBox=new SmartBox<>();
        
        numberSmartBox.addObject(20);
        numberSmartBox.addObject(35);
        numberSmartBox.addObject(21);

        wordSmartBox.addObject("happy");
        wordSmartBox.addObject("java");
        wordSmartBox.addObject("pineapple");

        DecimalFormat df=new DecimalFormat("#0.00");

        System.out.println("Average: "+df.format(numberSmartBox.computeAverage()));
        numberSmartBox.displayObjects();
        System.out.println("Maximum number: "+numberSmartBox.getMax(0));

        
        wordSmartBox.displayObjects();
        System.out.println("Longest word: "+wordSmartBox.getMax(" "));
    }
}
