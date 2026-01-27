class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var min = prices[0]

        for (i in 1 until prices.size) {
            min = minOf(min, prices[i])
            result = maxOf(result, prices[i] - min)
        }

        return result
    }
}
