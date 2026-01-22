class Solution {
    fun minimumPairRemoval(nums: IntArray): Int {
        var result = 0
        val list = nums.toMutableList()

        while (true) {
            if (list.size < 2) return result

            var minPair = MinimumPair(
                currentIndex = 0,
                nextIndex = 1,
                min = list[0] + list[1],
            )

            // 정렬이 되어있는지 확인
            for (i in 0 until list.size - 1) {
                if (list[i] > list[i + 1]) break
                if (i == list.lastIndex - 1) return result
            }

            for (i in 1 until list.size - 1) {
                val target = list[i] + list[i + 1]
                if (target < minPair.min) {
                    minPair = MinimumPair(
                        currentIndex = i,
                        nextIndex = i + 1,
                        min = target,
                    )
                }
            }

            list.removeAt(minPair.nextIndex)
            list.removeAt(minPair.currentIndex)

            list.add(minPair.currentIndex, minPair.min)

            result++
        }
    }

    data class MinimumPair(
        val currentIndex: Int,
        val nextIndex: Int,
        val min: Int,
    )
}
