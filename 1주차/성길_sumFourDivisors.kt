class Solution {
    fun sumFourDivisors(nums: IntArray): Int {
        var result = 0

        for (num in nums) {
            val set = hashSetOf<Int>()
            val limit = sqrt(num.toDouble()).toInt() // 제곱근을 구해서 최소한의 약수만 계산하기

            for (i in 1 until limit) {
                if (num % i == 0) {
                    set.add(i)
                    set.add(num / i) // 제곱근 보다 작은 약수는 limit 에 추가되지 않기 때문에 약수의 쌍도 넣기
                }
                if (set.size > 4) break
            }

            if (set.size == 4) result += set.sum()
        }

        return result
    }
}
