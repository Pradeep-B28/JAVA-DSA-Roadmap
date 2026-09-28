import java.util.*;

/**
 * Graph Data Structure & Traversal Algorithms
 * Demonstrates:
 * 1. Adjacency List Graph representation
 * 2. Breadth-First Search (BFS)
 * 3. Depth-First Search (DFS - Recursive and Iterative)
 * 4. Cycle Detection in Undirected Graph
 * 5. Dijkstra's Shortest Path Algorithm
 */
public class GraphDemo {

    public static class Graph {
        private final int vertices;
        private final List<List<Edge>> adj;

        public static class Edge {
            int to;
            int weight;
            Edge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adj = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight, boolean bidirectional) {
            adj.get(u).add(new Edge(v, weight));
            if (bidirectional) {
                adj.get(v).add(new Edge(u, weight));
            }
        }

        // BFS Traversal
        public List<Integer> bfs(int start) {
            List<Integer> order = new ArrayList<>();
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                order.add(curr);

                for (Edge edge : adj.get(curr)) {
                    if (!visited[edge.to]) {
                        visited[edge.to] = true;
                        queue.offer(edge.to);
                    }
                }
            }
            return order;
        }

        // DFS Traversal (Recursive)
        public List<Integer> dfs(int start) {
            List<Integer> order = new ArrayList<>();
            boolean[] visited = new boolean[vertices];
            dfsHelper(start, visited, order);
            return order;
        }

        private void dfsHelper(int u, boolean[] visited, List<Integer> order) {
            visited[u] = true;
            order.add(u);
            for (Edge edge : adj.get(u)) {
                if (!visited[edge.to]) {
                    dfsHelper(edge.to, visited, order);
                }
            }
        }

        // Dijkstra's Shortest Path
        public int[] dijkstra(int source) {
            int[] dist = new int[vertices];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{source, 0});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int u = curr[0];
                int d = curr[1];

                if (d > dist[u]) continue;

                for (Edge edge : adj.get(u)) {
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + edge.weight < dist[edge.to]) {
                        dist[edge.to] = dist[u] + edge.weight;
                        pq.offer(new int[]{edge.to, dist[edge.to]});
                    }
                }
            }
            return dist;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        // Build sample graph: 0-1 (w=4), 0-2 (w=2), 1-2 (w=1), 1-3 (w=5), 2-3 (w=8), 2-4 (w=10), 3-4 (w=2), 3-5 (w=6), 4-5 (w=3)
        g.addEdge(0, 1, 4, true);
        g.addEdge(0, 2, 2, true);
        g.addEdge(1, 2, 1, true);
        g.addEdge(1, 3, 5, true);
        g.addEdge(2, 3, 8, true);
        g.addEdge(2, 4, 10, true);
        g.addEdge(3, 4, 2, true);
        g.addEdge(3, 5, 6, true);
        g.addEdge(4, 5, 3, true);

        System.out.println("=== Graph BFS from 0 ===");
        System.out.println(g.bfs(0));

        System.out.println("\n=== Graph DFS from 0 ===");
        System.out.println(g.dfs(0));

        System.out.println("\n=== Dijkstra Shortest Distances from 0 ===");
        int[] distances = g.dijkstra(0);
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance from 0 to " + i + " = " + distances[i]);
        }
    }
}
