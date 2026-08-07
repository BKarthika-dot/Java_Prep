//knapsack algorithm - greedy approach
//time complexity O(nlogn)
import java.util.*;
class item{
    int profit;
    int weight;

    item(int profit,int weight){
        this.profit=profit;
        this.weight=weight;
    }
}
class knapsack{
    public static void main(String[] args){
        item[] items={
            new item(60,10),
            new item(100,20),
            new item(120,30)
        };

        int capacity=50;
        Arrays.sort(items,(x,y)->Double.compare((double)y.profit/y.weight , (double)x.profit/x.weight));
        
        double total_profit=0;

        for(item i: items){
            if(i.weight<=capacity){
                total_profit+=i.profit;
                capacity-=i.weight;
            }else{
                double fraction= (double)capacity/i.weight;
                total_profit+= fraction * i.profit;
                break;
            }
        }

        System.out.println(total_profit);
        
    }
}