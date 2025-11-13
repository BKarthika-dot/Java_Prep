import java.util.*;

interface Displayable{
    void displaySummary(Map<String,Object> summary);    //note that all methods in an interface are public 
}

abstract class DataVault<T>{

    abstract Map<String,Object> summarizeData();
}

class NumericVault <T extends Number> extends DataVault<T> implements Displayable{

    HashMap<String,ArrayList<Double>> evenOdd=new HashMap<>();

    NumericVault(){
        evenOdd.put("Even", new ArrayList<>());
        evenOdd.put("Odd", new ArrayList<>());
    }

    void addObject(T obj){
        double val = obj.doubleValue();
        if (val % 2 == 0){
            evenOdd.get("Even").add(val);
        }
        else{
            evenOdd.get("Odd").add(val);
        }
    }
    Map<String,Object> summarizeData(){
        return new HashMap<>(evenOdd);
    }

    
    public void displaySummary(Map<String,Object> summary){
        for(String str: summary.keySet()){
            System.out.println(str+" : "+summary.get(str));
        }
    }
    
}

class TextVault<T> extends DataVault<T> implements Displayable{
    HashMap<String,ArrayList<String>>words=new HashMap<>();
    
    TextVault(){
        words.put("Even Word", new ArrayList<>());
        words.put("Odd Word", new ArrayList<>());
    }

    void addObject(T obj){
        if(obj.toString().length() %2==0){
            words.get("Even Word").add(obj.toString());
        }
        else{
            words.get("Odd Word").add(obj.toString());
        }
    }
    Map<String,Object> summarizeData(){
        return new HashMap<>(words);
    }

    
    public void displaySummary(Map<String,Object> summary){        //if you don't add an access modifier over here, the method will be take as default (which has weaker access privileges); inherited methods must have same or higher access privilege as of that in the parent class; hence we've changed it to public
        for(String str: summary.keySet()){
            System.out.printf("%s : %s\n", str, summary.get(str));
        }
    }
}

class StringsAndNumbers_Storage{
    public static void main(String[] args){

        NumericVault<Integer> numVault=new NumericVault<>();
        
        TextVault<String> wordVault=new TextVault<>();

        numVault.addObject(12);
        numVault.addObject(55);
        numVault.addObject(65);
        numVault.addObject(14);

        wordVault.addObject("java");
        wordVault.addObject("programming");
        wordVault.addObject("math");

        Map<String,Object> summary=numVault.summarizeData();
        numVault.displaySummary(summary);

        Map<String,Object> word_summary=wordVault.summarizeData();
        wordVault.displaySummary(word_summary);
    }
}
