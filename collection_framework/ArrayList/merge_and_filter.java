/*You are given two ArrayList<Integer> objects — listA and listB — each containing integers.
Write a program to:
Merge them into a single list called mergedList.
Remove duplicates from mergedList.
Sort the final list in ascending order.
Display the result.

Concepts tested:
Merging ArrayLists
Removing duplicates using a HashSet
Sorting
Real-world data cleaning logic */

import java.util.*;

class duplicates{
    static HashSet<Integer> remove_duplicates(ArrayList<Integer> lst){
        HashSet<Integer> set=new HashSet<>();

        for(int num: lst){
            set.add(num);
        }

        return set;
    }
}
class merge_and_filter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        ArrayList<Integer> listA=new ArrayList<>();
        ArrayList<Integer> listB=new ArrayList<>();
        
        listA.add(10);
        listA.add(34);
        listA.add(19);
        listA.add(31);

        listB.add(34);
        listB.add(12);
        listB.add(10);
        listB.add(15);

        listA.addAll(listB);
        
        listA=new ArrayList<>(duplicates.remove_duplicates(listA));   //we cant assign a set to an arraylist directly; so we're creating a new array list that contains the values of the set

        listA.sort(null);

        System.out.println("Merged list with unique values: "+listA);
    }
}