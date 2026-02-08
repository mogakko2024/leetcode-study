class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val left = mutableListOf<IntArray>()
        val right = mutableListOf<IntArray>()

        for (interval in intervals) {
            if (interval[1] < newInterval[0]) {
                left.add(interval)
            } else if (interval[0] > newInterval[1]) {
                right.add(interval)
            } else {
                newInterval[0] = minOf(interval[0], newInterval[0])
                newInterval[1] = maxOf(interval[1], newInterval[1])
            }
        }

        return arrayOf(*left.toTypedArray(), intArrayOf(newInterval[0], newInterval[1]), *right.toTypedArray())
    }
}
