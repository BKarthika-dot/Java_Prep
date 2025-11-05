/*
 * Program: CountWordFrequency
 * Description:
 * This program takes a list of words as input and counts how many times
 * each word appears. It stores words in an ArrayList and uses a TreeMap
 * to map each word to its frequency count. Since TreeMap is used, the
 * output is automatically sorted in alphabetical order.
 *
 * Example:
 * Input:
 * apple
 * banana
 * apple
 * cherry
 * banana
 * apple
 *
 * Output:
 * apple : 3
 * banana : 2
 * cherry : 1
 *
 * Key Concepts Used: ArrayList, TreeMap, Iterator, containsKey(), keySet()
 */



import java.util.*;

class Frequency{
    ArrayList<String> lst=new ArrayList<>();
    Frequency(ArrayList<String> lst){
        this.lst=lst;
    }

    TreeMap<String,Integer> Counting(){
        TreeMap<String,Integer> MyMap=new TreeMap<>();

        Iterator<String> it=lst.iterator();

        while(it.hasNext()){
            String word=it.next();

            if(MyMap.containsKey(word)){
                MyMap.put(word,MyMap.get(word)+1);
            }
            else{
                MyMap.put(word,1);
            }
        }
        return MyMap;
    }
}
class CountWordFrequency {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> words=new ArrayList<>();
        while(true){
            String word=sc.nextLine();
            if(word.isEmpty()){
                break;
            }
            words.add(word);
        }

        Frequency frequency=new Frequency(words);

        TreeMap<String,Integer> MyTree=frequency.Counting();

        for(String str: MyTree.keySet()){
            System.out.println(str+" : "+MyTree.get(str));
        }
    }
}
