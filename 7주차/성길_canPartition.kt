class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        val mid = sum / 2

        // 더한 값이 홀수면 소수점이 나오기 때문에 true 가 될 수 없음
        if (sum % 2 != 0) return false

        val dp = BooleanArray(mid + 1) // 현재 값이 도달할 수 있는지 확인
        dp[0] = true

        for (num in nums) {
            for (i in mid downTo num) {
                if (dp[i - num]) { // 이전에 도달했던 값으로 만들 수 있는지 확인
                    dp[i] = true
                }
            }

            if (dp[mid]) return true // 도달했으면 정답 리턴
        }

        return dp[mid]
    }
}
