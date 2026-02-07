class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        lastIdx = -1

        for i, interval in enumerate(intervals):
            if interval[1] < newInterval[0]:
                result.append(interval)
            elif interval[0] > newInterval[1]:
                result.append(newInterval)
                lastIdx = i
                break
            else:
                newInterval[0] = min(interval[0], newInterval[0])
                newInterval[1] = max(interval[1], newInterval[1])
        
        if lastIdx == -1:
            result.append(newInterval)
        else:
            result += intervals[lastIdx:]
        
        return result
