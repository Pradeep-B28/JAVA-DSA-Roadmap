import java.util.*;

/**
 * Recursion and Backtracking Patterns
 * Demonstrates:
 * 1. Power Set (Subsets generation)
 * 2. Permutations of an Array
 * 3. N-Queens Backtracking Problem
 */
public class RecursionBacktrackingDemo {

    // 1. Subsets Generator
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackSubsets(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    // 2. Permutations Generator
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrackPermute(nums, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackPermute(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrackPermute(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    // 3. N-Queens Solver (Count valid configurations)
    public static int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); // row - col
        Set<Integer> diag2 = new HashSet<>(); // row + col
        return solveQueens(0, n, cols, diag1, diag2);
    }

    private static int solveQueens(int row, int n, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) return 1;
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            count += solveQueens(row + 1, n, cols, diag1, diag2);

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Subsets of [1, 2, 3] ===");
        int[] set = {1, 2, 3};
        System.out.println(subsets(set));

        System.out.println("\n=== 2. Permutations of [1, 2, 3] ===");
        System.out.println(permute(set));

        System.out.println("\n=== 3. 4-Queens Total Solutions ===");
        System.out.println("N=4 Solutions: " + totalNQueens(4));
        System.out.println("N=8 Solutions: " + totalNQueens(8));
    }
}
