//using priority queue
import java.util.*;

class Node{
    char ch;
    int freq;
    Node left,right;

    //constructor for the leaf node  - creating nodes for original characters
    Node(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }

    //for internal nodes where parent doesnt represent a character
    Node(int freq,Node left,Node right){
        this.ch='\0';
        this.freq=freq;
        this.left=left;
        this.right=right;
    }
}
class HuffmanCoding{
    public static void printCodes(Node root, String code){
        if(root==null) return;

        if(root.left==null && root.right==null){
            System.out.println(root.ch + ": "+code);
            return;
        }
        printCodes(root.left,code+"1");
        printCodes(root.right,code+"0");
    }
    public static void main(String[] args){
        Node a=new Node('a',5);
        Node b=new Node('b',9);
        Node c=new Node('c',3);
        Node d=new Node('d',7);
        Node e=new Node('e',2);

        //comparator tells the priority queuewhich object should go first
        PriorityQueue<Node> pq=new PriorityQueue<>((x,y)->x.freq-y.freq);
        
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        pq.offer(d);
        pq.offer(e);

        while(pq.size()>1){
            Node left=pq.poll();
            Node right=pq.poll();

            Node parent=new Node(left.freq+right.freq,left,right);
            pq.offer(parent);
        }
        Node root=pq.poll();

        printCodes(root,"");
        
    }
}