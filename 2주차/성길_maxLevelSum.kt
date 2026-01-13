class Solution {
    private val map = mutableMapOf<Int, Int>()

    fun maxLevelSum(root: TreeNode?): Int {
        var level = 1

        map[level] = root!!.`val`

        dfs(root, ++level)

        val sortedList = map.toList().sortedWith(
            compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first }
        )
        return sortedList.first().second
    }

    private fun dfs(node: TreeNode?, level: Int): Int? {
        if (node == null) return null

        val left = dfs(node.left, level + 1)
        val right = dfs(node.right, level + 1)

        if (left != null || right != null) {
            val leftVal = left ?: 0
            val rightVal = right ?: 0
            val original = map.getOrDefault(level, 0)
            map[level] = original + leftVal + rightVal
        }

        return node.`val`
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * DFS 로도 풀 수 있지만 별도의 몇층의 합계인지 구분하는
 * 맵을 만들지 않아 공간 복잡도를 감소 시키고 불필요한 정렬 코드 삭제함으로서 시간 복잡도 감소
 */
class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode?>()
        queue.offer(root)

        var maxLevel = 1
        var maxSum = Int.MIN_VALUE
        var currentLevel = 1

        while (queue.isNotEmpty()) {
            val size = queue.size
            var currentLevelSum = 0

            for (i in 0 until size) {
                val node = queue.poll()
                val nodeVal = node?.`val` ?: 0
                currentLevelSum += nodeVal
                if (node?.left != null) queue.offer(node.left)
                if (node?.right != null) queue.offer(node.right)
            }

            if (currentLevelSum > maxSum) { // 클때만 바꾸면 최소 레벨
                maxLevel = currentLevel
                maxSum = currentLevelSum
            }

            currentLevel++
        }

        return maxLevel
    }
}
