import math


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.max_level = 0

    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        tree_level = int(sqrt(10**5))
        sums = [0 for i in range(tree_level)]
        
        self.dfs(root, 0, sums)
        level_sums = sums[:self.max_level + 1]
        
        return level_sums.index(max(level_sums)) + 1
    
    def dfs(self, cur: TreeNode, level: int, sums: list[int]) -> int:
        if cur is not None:
            sums[level] += cur.val

        self.max_level = max(self.max_level, level)
        
        if cur.left is not None:
            self.dfs(cur.left, level + 1, sums)

        if cur.right is not None:
            self.dfs(cur.right, level + 1, sums)
