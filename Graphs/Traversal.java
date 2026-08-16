//implementing depth first and breadth first traversals in java
//dfs implemented using stack
//bfs implemented using queue
import java.util.*;
class Traversal{

    public static void DFS(HashMap<Character,List<Character>> graph){
        Deque<Character> stack=new ArrayDeque<>();

        Set<Character> visited=new HashSet<>();

        char firstKey=graph.keySet().iterator().next();

        stack.push(firstKey);

        while(!stack.isEmpty()){
            char key=stack.pop();

            if(visited.contains(key)){
                continue;
            }
            visited.add(key);
            System.out.print(key+" ");

            for(char c:graph.get(key)){

                if(!visited.contains(c)){
                    stack.push(c);
                }
            }
        }
        System.out.println();
    }

    public static void BFS(HashMap<Character,List<Character>> graph){
        Deque <Character> queue=new ArrayDeque<>();

        Set<Character> visited=new HashSet<>();

        char firstKey=graph.keySet().iterator().next();

        queue.offer(firstKey);

        while(!queue.isEmpty()){
            char key=queue.poll();
            if(visited.contains(key)){
                continue;
            }
            visited.add(key);
            System.out.print(key+" ");

            for(char c: graph.get(key)){
                if(!visited.contains(c)){
                    queue.offer(c);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        HashMap<Character,List<Character>> graph=new HashMap<>();
        graph.put('a',Arrays.asList('b','c'));
        graph.put('b',Arrays.asList('d'));
        graph.put('c',Arrays.asList('e'));
        graph.put('d',Arrays.asList('f'));
        graph.put('f',Collections.emptyList());
        graph.put('e',Collections.emptyList());

        DFS(graph);
        BFS(graph);
    }
}