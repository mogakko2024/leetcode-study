class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        def smallestBitwise(target: int) -> int:
            for i in range(1, 1001):
                if i | i + 1 == target:
                    return i
            
            return -1
        
        ans = []
        for num in nums:
            ans.append(smallestBitwise(num))
        
        return ans

