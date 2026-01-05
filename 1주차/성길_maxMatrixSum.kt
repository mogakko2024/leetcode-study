class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var negative = 0
        val n = matrix.size
        var min = Int.MAX_VALUE

        for (i in 0 until n) {
            for (j in 0 until n) {
                val target = matrix[i][j]
                val abs = abs(target)
                sum += abs
                min = minOf(min, abs)
                if (target < 0) negative++
            }
        }

        // 음수의 개수가 홀수일 경우 음수가 무조건 하나 나오기 때문에 가장 작은 값을 선택하여 뺌
        if (negative % 2 != 0) {
            return sum - (2L * min)
        }

        // 음수의 개수가 짝수일 경우 모두 양수로 만들 수 있음
        return sum
    }
}
