class Solution {
    val sums = mutableListOf<Long>()

    fun maxProduct(root: TreeNode?): Int {
        val mod = 1_000_000_007L
        val sum = dfs(root)
        var max = 0L

        for (s in sums) {
            max = maxOf(max, (sum - s) * s)
        }

        return (max % mod).toInt()
    }

    private fun dfs(root: TreeNode?): Long {
        if (root == null) return 0L // 자식이 없는 경우 0 리턴

        // 왼쪽 노드부터 순차적으로 마지막 노드까지 계산함
        // 마지막 노드일때는 본인의 root.`val` 을 리턴해줌
        val leftSum = dfs(root.left)
        val rightSum = dfs(root.right)

        val current = root.`val`
        val sum = current + leftSum + rightSum

        // 각 노드만큼 합계를 계산해두고 루트 노드의 총계와
        // 빼서 나올 수 있는 가장 큰 값을 계산할때 사용
        sums.add(sum)

        return sum
    }
}
