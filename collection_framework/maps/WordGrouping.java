/*
 * Program: GroupWordsByLetter
 * Description:
 * This program takes a list of words as input and groups them
 * based on their starting letter. It uses an ArrayList to store
 * the words and a HashMap<Character, ArrayList<String>> to organize
 * them by their first character. The grouped words are then printed
 * in the format:
 *
 * Example:
 * a: apple apricot
 * b: banana berry
 * c: cherry
 *
 * Key Concepts Used: ArrayList, HashMap, Iterator, keySet()
 */


import java.util.*;

class GroupWordsByLetter{

    ArrayList<String> lst=new ArrayList<>();
    GroupWordsByLetter(ArrayList<String> lst){
        this.lst=lst;
    }

    HashMap<Character,ArrayList<String>> grouping(){
        HashMap<Character,ArrayList<String>> MyMap= new HashMap<>();

        Iterator<String> it=lst.iterator();
        while(it.hasNext()){
            String word=it.next();
            char ch=word.charAt(0);
            if(!MyMap.containsKey(ch)){
                ArrayList<String> word_list=new ArrayList<>();
                word_list.add(word);

                MyMap.put(ch,word_list);
            }
            else{
                ArrayList<String> word_list=MyMap.get(ch);
                word_list.add(word);
            }
        }
        return MyMap;
    }
}
class WordGrouping {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> words=new ArrayList<>();
        while(true){
            String word=sc.nextLine();
            if(word.isEmpty())break;
            words.add(word);
        }

        GroupWordsByLetter group=new GroupWordsByLetter(words);

        HashMap<Character,ArrayList<String>> MyMap=group.grouping();

        for(char ch: MyMap.keySet()){
            System.out.print(ch+" : ");
            for(String word: MyMap.get(ch)){
                System.out.print(word+" ");
            }
            System.out.println();
        }

    }
}
