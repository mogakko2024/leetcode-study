class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length
        val dp = Array(n + 1) { IntArray(m + 1) } // ASCII 의 합산을 넣기 위해 IntArray 로 선언

        for (i in 1 .. n) {
            for (j in 1 .. m) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + s1[i - 1].code
                } else { // dp[n][m] 을 가장 큰 수로 만들기 위해서 왼쪽 혹은 위에서 가장 큰 수를 가져옴
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        val lcsTotal = dp[n][m]
        val s1Remainder = s1.sumOf { it.code }
        val s2Remainder = s2.sumOf { it.code }

        return (s1Remainder + s2Remainder) - 2 * lcsTotal
    }
}
