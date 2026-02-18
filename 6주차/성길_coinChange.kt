class Solution {
   fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { Int.MAX_VALUE - 1 }

        dp[0] = 0

        for (i in 1 .. amount) {
            for (coin in coins) {
                if (coin > i) continue

                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }

        return if (dp[amount] == Int.MAX_VALUE - 1) -1 else dp[amount]
    }
}
