from queue import PriorityQueue

class Solution:
  def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
    que = PriorityQueue()
    
    for val in happiness:
        que.put(-1 * val)
    
    turns, result = 0, 0
    for i in range(k):
        val = max(0, -1 * que.get() - turns)
        
        result += val
        turns += 1
    
    return result
