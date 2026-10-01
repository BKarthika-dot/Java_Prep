import java.util.*;

public class KruskalAlgorithm{

    static class Edge{
        int u,v,weight;

        Edge(int u,int v,int weight){
            this.u=u;
            this.v=v;
            this.weight=weight;
        }
    }

    public static int find(int [] parent,int x){
        if(parent[x]==x){
            return x;
        }

        parent[x]=find(parent,parent[x]);
        return parent[x];
    }

    //union of 2 sets
    public static void union(int [] parent,int [] rank,int u,int v){
        int pu=find(parent,u);
        int pv=find(parent,v);

        if(pu==pv) return;

        if(rank[pu]<rank[pv]){
            parent[pu]=pv;
        }
        else{
            parent[pv]=pu;
            rank[pu]++;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int m = scanner.nextInt();

        Edge[] edges = new Edge[m];

        // input edges
        for (int i = 0; i < m; i++) {

            System.out.print("Enter u, v and weight: ");

            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();

            edges[i] = new Edge(u, v, weight);
        }

        Arrays.sort(edges,(a,b)->a.weight-b.weight);

        //initialise disjoint set

        int [] parent=new int[n];
        int [] rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        int mstWeight=0;
        int edgeCount=0;

        System.out.println("\nEdges in MST:");

        for(int i=0;i<m&&edgeCount<n-1;i++){
            Edge edge=edges[i];

            int pu=find(parent,edge.u);
            int pv=find(parent,edge.v);

            if(pu!=pv){
                System.out.println(
                    edge.u + " - " + edge.v + " : " + edge.weight
                );

                mstWeight += edge.weight;
                edgeCount++;

                union(parent, rank, edge.u, edge.v);
            }
        }

        System.out.println("Minimum Spanning Tree Weight = " + mstWeight);
        scanner.close();

    }
}