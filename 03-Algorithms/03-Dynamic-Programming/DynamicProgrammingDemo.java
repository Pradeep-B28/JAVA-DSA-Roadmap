import java.util.Arrays;

/**
 * Dynamic Programming Paradigms & Classic Problems
 * Demonstrates:
 * 1. 1D DP: Climbing Stairs / Fibonacci (Memoization vs Tabulation)
 * 2. 0/1 Knapsack Problem (Tabulation)
 * 3. Coin Change Problem (Minimum coins to make amount)
 * 4. Longest Common Subsequence (LCS)
 */
public class DynamicProgrammingDemo {

    // 1. 0/1 Knapsack
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    // 2. Coin Change (Minimum Coins to make amount)
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 3. Longest Common Subsequence
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println("=== 1. 0/1 Knapsack Test ===");
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        System.out.println("Max Value: " + knapsack(weights, values, capacity));

        System.out.println("\n=== 2. Coin Change Test ===");
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Min coins for 11: " + coinChange(coins, amount));

        System.out.println("\n=== 3. Longest Common Subsequence ===");
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println("LCS of " + s1 + " and " + s2 + " = " + longestCommonSubsequence(s1, s2));
    }
}
