// 0/1 Knapsack implementation using backtracking
import java.util.*;
class Item{
    int weight;
    int profit;
    Item(int weight,int profit){
        this.weight=weight;
        this.profit=profit;
    }
}
public class Knapsack {
    static int maxProfit=0;

    private static void backtrack(Item[] items,int currentProfit,int currentWeight,int maxWeight,boolean[] chosen,boolean[] best_chosen,int start){

        //basecase
        if(start==items.length){
            if(maxProfit<currentProfit){
                maxProfit=currentProfit;

                for(int i=0;i<items.length;i++){
                    best_chosen[i]=chosen[i];
                }
            }
            return;
        }
        

        //dont pick the item

        backtrack(items,currentProfit,currentWeight,maxWeight,chosen,best_chosen,start+1);

        //condition to pick the item
        if(currentWeight+items[start].weight<=maxWeight){
            chosen[start]=true;
            backtrack(items,currentProfit+items[start].profit,currentWeight+items[start].weight,maxWeight,chosen,best_chosen,start+1);

            chosen[start]=false;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of items: ");
        int n=sc.nextInt();

        Item [] items=new Item[n];
        boolean [] chosen=new boolean[n];
        boolean [] best_chosen=new boolean[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter weight of item "+(i+1));
            int weight=sc.nextInt();
            System.out.println("Enter profit of item "+(i+1));
            int profit=sc.nextInt();
            
            items[i]=new Item(weight,profit);
        }

        
        int currentProfit=0;
        int currentWeight=0;
        int maxWeight=50;

        backtrack(items,currentProfit,currentWeight,maxWeight,chosen,best_chosen,0);
        System.out.println("Total Profit Obtained: "+ maxProfit);

        System.out.println("Chosen Items: ");
        for(int i=0;i<n;i++){
            if(best_chosen[i]){
                System.out.println("Item "+(i+1));
            }
        }
         
    }
}
