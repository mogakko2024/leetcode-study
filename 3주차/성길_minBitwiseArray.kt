class Solution {
    fun minBitwiseArray(nums: List<Int>): IntArray {
        val n = nums.size
        val result = IntArray(n) { -1 }

        for (i in 0 until n) {
            for (j in 0 until nums[i]) {
                if (j or (j + 1) == nums[i]) {
                    result[i] = j
                    break
                }
            }
        }

        return result
    }
}
