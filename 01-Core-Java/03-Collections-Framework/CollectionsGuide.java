import java.util.*;

/**
 * Phase 1: Java Collections Framework
 * Demonstrates: List, Set, Map, PriorityQueue, and Iteration
 */
public class CollectionsGuide {

    public static void main(String[] args) {
        System.out.println("=== Java Collections Framework Overview ===");

        // 1. List (ArrayList, LinkedList)
        List<String> topics = new ArrayList<>(List.of("Arrays", "LinkedList", "Trees", "Graphs"));
        topics.add("Dynamic Programming");
        System.out.println("Topics List: " + topics);

        // 2. Set (HashSet, TreeSet for uniqueness)
        Set<Integer> uniqueNums = new HashSet<>(List.of(5, 2, 8, 2, 5, 1));
        System.out.println("Unique Numbers (HashSet): " + uniqueNums);

        // 3. Map (HashMap - Key-Value Pairs)
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = {"dsa", "java", "dsa", "leetcode", "java", "dsa"};
        for (String w : words) {
            wordFrequency.put(w, wordFrequency.getOrDefault(w, 0) + 1);
        }
        System.out.println("Word Frequencies: " + wordFrequency);

        // 4. PriorityQueue (Min-Heap by default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(List.of(10, 4, 15, 1, 7));
        System.out.print("Min-Heap Polling: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }
}
