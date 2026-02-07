class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxVal, result = nums[0], nums[0]
        
        for i in range(1, len(nums)):
            if maxVal + nums[i] <= nums[i]:
                maxVal = nums[i]
            else:
                maxVal += nums[i]

            result = max(result, maxVal)
        return result
