class Solution {
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        val (_, node) = dfs(root) // 결과로 올라온 노드가 가장 깊으면서 최소 노드
        return node
    }

    private fun dfs(node: TreeNode?): Pair<Int, TreeNode?> {
        if (node == null) return Pair(0, null)

        val (leftDepth, leftNode) = dfs(node.left)
        val (rightDepth, rightNode) = dfs(node.right)

        // 자식 노드 수가 같은 최소 트리를 찾기
        if (leftDepth == rightDepth) {
            return Pair(leftDepth + 1, node) // 가장 깊은 노드인지 알기 위해서 count + 1
        }

        return if (leftDepth > rightDepth) {
            Pair(leftDepth + 1, leftNode)
        } else Pair(rightDepth + 1, rightNode)
    }
}
