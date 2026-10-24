import java.util.*;
class TreeImplementation{

    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    Node root; //declare root node

    TreeImplementation(){
        root=null;
    }

    //defining insert function for level order insertion
    private void insertVal(int data){
        if(root==null){
            root=new Node(data);
            return;
        }

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr=queue.poll();

            if(curr.left==null){
                curr.left=new Node(data);
                return;
            }

            else{
                queue.add(curr.left);
            }

            if(curr.right==null){
                curr.right=new Node(data);
                return;
            }

            else{
                queue.add(curr.right);
            }
        }
    }


    //tree traversals
    private void preOrder(Node root){
        if(root==null) return;
        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }

    private void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data+" ");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TreeImplementation tree=new TreeImplementation();

        System.out.println("Enter integers to insert (-1 to stop):");

        while(sc.hasNextInt()){
            int data=sc.nextInt();
            if(data==-1) break;
            tree.insertVal(data);
        }


        System.out.print("Preorder: ");
        tree.preOrder(tree.root);

        System.out.print("\nInorder: ");
        tree.inOrder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postOrder(tree.root);

        sc.close();
    }
}