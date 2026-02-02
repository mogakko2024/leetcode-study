class Solution {
    fun search(nums: IntArray, target: Int): Int { // 이진 탐색으로 찾기
        var left = 0
        var right = nums.size

        while (left < right) {
            val mid = (left + right) / 2

            if (target < nums[mid]) {
                right--
            } else { 
                left++
            }

            if (target == nums[mid]) return mid
        }

        return -1
    }
}
