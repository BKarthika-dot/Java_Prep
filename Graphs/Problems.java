
import java.util.*;
class Problems{

    //implementing dfs for hasPath problem
    public static boolean hasPath(HashMap<Character,List<Character>> graph, char src,char dest){
        Deque<Character> stack=new ArrayDeque<>();
        Set<Character> visited=new HashSet<>();

        stack.push(src);

        while(!stack.isEmpty()){
            char c=stack.pop();
            if(visited.contains(c)) continue;
            if(c==dest){
                System.out.print(c);
                System.out.println("Found");
                return true;
            }

            visited.add(c);
            System.out.print(c+" ");

            for(char a:graph.get(c)){
                if(!visited.contains(a)){
                    stack.push(a);
                }
            }

        }
        System.out.println("Not found");
        return false;
    }
    public static int connectedComponentCount(HashMap<Character,List<Character>> graph){
        //using BFS
        Set<Character> visited=new HashSet<>();
        Deque <Character> queue=new ArrayDeque<>();

        int count=0; //number of components
        
        for(char a: graph.keySet()){
            
            if(visited.contains(a)) continue;
            count++;
            visited.add(a);
            queue.offer(a);
            

            while(!queue.isEmpty()){
                char node=queue.poll();

                for(char c:graph.get(node)){

                    if(!visited.contains(c)){
                        visited.add(c);
                        queue.offer(c);
                    }
                }
            }
        }
        return count;
        
    }

    public static int largestComponent(HashMap<Character,List<Character>> graph){
        //using DFS

        int maxSize=-1;
        Set<Character> visited=new HashSet<>();
        Deque<Character> stack=new ArrayDeque<>();

        for(char a: graph.keySet()){
            if(visited.contains(a)) continue;
            stack.push(a);
            visited.add(a);
            int size=1;

            while(!stack.isEmpty()){
                char node=stack.pop();

                for(char c:graph.get(node)){

                    if(!visited.contains(c)){
                        visited.add(c);
                        stack.push(c);
                        size++;
                    }
                }
            }

            maxSize = Math.max(size, maxSize);
        }
        return maxSize;
    }

    public static void shortestPath(HashMap<Character,List<Character>> graph,char src,char dest){
        //using BFS - computationally best way to find shortest path in unweighted graph
        //In an unweighted graph, the first time BFS reaches a node, it has reached it using the minimum possible number of edges.
        Set<Character> visited =new HashSet<>();
        Deque<Character> queue=new ArrayDeque<>();

        HashMap<Character,Character> parent=new HashMap<>();
        parent.put(src,null);
        queue.offer(src);
        visited.add(src);

        while(!queue.isEmpty()){
            char node=queue.poll();
            if(node==dest) break;

            for(char c:graph.get(node)){
                if(!visited.contains(c)){
                    queue.offer(c);
                    visited.add(c);
                    parent.put(c,node); //node is the parent of c
                }
            }
        }
        if(!visited.contains(dest)){
            System.out.println("Node not found");
            return;
        }

        //reconstruction
        ArrayList<Character> path=new ArrayList<>();

        char current=dest;
        while(current!=src){
            path.add(current);
            current=parent.get(current);
        }
        path.add(src);
        Collections.reverse(path);
        System.out.println(path);

    }
    public static void main(String[] args){
        HashMap<Character,List<Character>> graph=new HashMap<>();
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Arrays.asList('d', 'e'));
        graph.put('c', Arrays.asList('f', 'g'));
        graph.put('d', Arrays.asList('h'));
        graph.put('e', Arrays.asList('i', 'j'));
        graph.put('f', Arrays.asList('k'));
        graph.put('g', Arrays.asList('e', 'l'));
        graph.put('h', Arrays.asList('m'));
        graph.put('i', Arrays.asList('f'));
        graph.put('j', Arrays.asList('n'));
        graph.put('k', Arrays.asList('g'));
        graph.put('l', Collections.emptyList());
        graph.put('m', Arrays.asList('j'));
        graph.put('n', Arrays.asList('o'));
        graph.put('o', Arrays.asList('e'));

        hasPath(graph, 'a', 'n');


        //undirected graph (edge list needs to be converted to adjacency list)
        ArrayList<List<Character>> edges = new ArrayList<>(List.of(
            List.of('i','j'),
            List.of('k','i'),
            List.of('m','k'),
            List.of('k','l'),
            List.of('o','n')
        ));

        HashMap<Character,List<Character>> adjacencyList=new HashMap<>();
        for(List<Character> edge: edges){
            char a=edge.get(0);
            char b=edge.get(1);

            if(!adjacencyList.containsKey(a)){
                adjacencyList.put(a,new ArrayList<>());
            }
            adjacencyList.get(a).add(b);

            if(!adjacencyList.containsKey(b)){
                adjacencyList.put(b,new ArrayList<>());
            }
            adjacencyList.get(b).add(a);
        }

        hasPath(adjacencyList,'i','m');


        //counting components in graph
        HashMap<Character, List<Character>> network = new HashMap<>();

        // Component 1
        network.put('a', Arrays.asList('b', 'c'));
        network.put('b', Arrays.asList('d', 'e'));
        network.put('c', Arrays.asList('f'));
        network.put('d', Collections.emptyList());
        network.put('e', Arrays.asList('g'));
        network.put('f', Collections.emptyList());
        network.put('g', Collections.emptyList());

        // Component 2
        network.put('h', Arrays.asList('i', 'j'));
        network.put('i', Arrays.asList('k'));
        network.put('j', Collections.emptyList());
        network.put('k', Collections.emptyList());

        // Component 3
        network.put('l', Arrays.asList('m'));
        network.put('m', Arrays.asList('n', 'o'));
        network.put('n', Collections.emptyList());
        network.put('o', Collections.emptyList());

        // Component 4
        network.put('p', Arrays.asList('q'));
        network.put('q', Collections.emptyList());

        System.out.println("No of connected components is: "+connectedComponentCount(network));
        System.out.println("Size of largest connected component is: "+largestComponent(network));

        shortestPath(network,'a','g');

    }
}