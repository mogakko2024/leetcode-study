class Solution:
  def maxMatrixSum(self, matrix: List[List[int]]) -> int:
    negativeCount, sumMatrix, minValue = 0, 0, 10**5
    
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if matrix[i][j] < 0:
                negativeCount += 1
            
            minValue = min(minValue, abs(matrix[i][j]))
            sumMatrix += abs(matrix[i][j])
    
    if negativeCount % 2 != 0:
        sumMatrix -= 2 * minValue

    return sumMatrix
