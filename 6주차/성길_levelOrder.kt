class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        dfs(node = root, level = 0, result = result)

        return result
    }

    private fun dfs(node: TreeNode?, level: Int, result: MutableList<MutableList<Int>>) {
        if (node == null) return
        
        if (level == result.size) {
            result.add(mutableListOf())
        }
        
        result[level].add(node.`val`)

        dfs(node = node.left, level = level + 1, result = result)
        dfs(node = node.right, level = level + 1, result = result)
    }
}
