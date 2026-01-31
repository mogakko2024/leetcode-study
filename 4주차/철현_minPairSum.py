class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        sorted_nums = sorted(nums)
        length = len(sorted_nums)
        result = 0

        for i in range(length//2):
            result = max(result, sorted_nums[i] + sorted_nums[length-i-1])

        return result
