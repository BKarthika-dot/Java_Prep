import java.util.*;

class ZigZag{

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static Node root=null;

    //level order insertion
    static void insertVal(int data){
        if(root==null){
            root=new Node(data);
            return;
        }

        Queue<Node> queue =new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr=queue.poll();

            if(curr.left==null){
                curr.left=new Node(data);
                return;
            }
            else queue.add(curr.left);

            if(curr.right==null){
                curr.right=new Node(data);
                return;
            }
            else queue.add(curr.right);
        }
    }

    static void reverseQueue(Queue<Node> queue){
        Stack<Node> stack=new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }

    static void zigZag(){
        if(root==null) return;

        boolean leftToRight=true;

        Deque<Node> dq=new LinkedList<>();
        dq.add(root);

        while(!dq.isEmpty()){
            int levelSize=dq.size();

            for(int i=0;i<levelSize;i++){
                if(leftToRight){
                    Node curr=dq.pollFirst();
                    System.out.print(curr.data+" ");

                    if(curr.left!=null) dq.addLast(curr.left);
                    if(curr.right!=null) dq.addLast(curr.right);
                }

                else{
                    Node curr=dq.pollLast();
                    System.out.print(curr.data+" ");

                    if(curr.left!=null) dq.addFirst(curr.left);
                    if(curr.right!=null) dq.addFirst(curr.right);
                }
            }
            leftToRight=!leftToRight;
        }
    }
    public static void main(String[] args){

        int [] arr={3,12,9,5,10,6,7,1};

        for(int i:arr){
            insertVal(i);
        }

        zigZag();
    }


}