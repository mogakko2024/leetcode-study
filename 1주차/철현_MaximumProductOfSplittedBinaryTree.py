# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        sums = []
        total = self.dfs(root, sums)
        result = 0

        for sum in sums:
            result = max(result, sum * (total - sum))    

        return result % (10**9 + 7)
    
    def dfs(self, current: Optional[TreeNode], sums: List[int]) -> int:
        if current == None:
            return 0
        
        left = self.dfs(current.left, sums)
        right = self.dfs(current.right, sums)

        total = current.val + left + right
        sums.append(total)

        return total
