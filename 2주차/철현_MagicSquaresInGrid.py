class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        result = 0
        for i in range(len(grid) - 2):
            for j in range(len(grid[0]) - 2):
                if self.isMagicSquare(grid, i, j):
                    result += 1
        
        return result
    
    def isMagicSquare(self, grid: List[List[int]], row: int, col: int) -> bool:
        number_check = [0 for _ in range(9)]
        target = grid[row][col] + grid[row][col + 1] + grid[row][col + 2] 
        
        for i in range(3):
            for j in range(3):
                if grid[row + i][col + j] < 1 or grid[row + i][col + j] > 9:
                    return False
                number_check[grid[row + i][col + j] - 1] = 1
        
        for i in range(9):
            if number_check[i] != 1:
                return False

        # row
        for i in range(3):
            if sum(grid[row + i][col:col + 3]) != target:
                return False
        
        # col
        for j in range(3):
            if grid[row][col + j] + grid[row + 1][col + j] + grid[row + 2][col + j] != target:
                return False
        
        # diagonal
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != target or
            grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != target):
            return False

        return True
