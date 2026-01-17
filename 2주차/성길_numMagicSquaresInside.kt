class Solution {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var result = 0
        val n = grid.size // 3
        val m = grid[0].size // 4

        // n 과 m 이 3 미만일때 0 리턴
        if (n < 3 || m < 3) return 0

        // n 과 m 을 3이상일때 한번씩 옮기기?
        // n 과 m 을 3을 빼서 나온 카운트만큼 옮기기
        for (i in 0..n - 3) {
            for (j in 0..m - 3) {
                val numList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                val list = mutableListOf<Int>()

                fun check(row: Int, col: Int): Int {
                    val target = grid[row][col]
                    numList.remove(target)
                    return target
                }

                val target = check(i, j) + check(i, j + 1) + check(i, j + 2)

                list.add(check(i + 1, j) + check(i + 1, j + 1) + check(i + 1, j + 2))
                list.add(check(i + 2, j) + check(i + 2, j + 1) + check(i + 2, j + 2))

                list.add(check(i, j) + check(i + 1, j) + check(i + 2, j))
                list.add(check(i, j + 1) + check(i + 1, j + 1) + check(i + 2, j + 1))
                list.add(check(i, j + 2) + check(i + 1, j + 2) + check(i + 2, j + 2))

                list.add(check(i, j) + check(i + 1, j + 1) + check(i + 2, j + 2))
                list.add(check(i, j + 2) + check(i + 1, j + 1) + check(i + 2, j))

                if (list.all { it == target } && numList.isEmpty()) {
                    result++
                }
            }
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 불필요한 numList 를 booleanArray 로 바꿔서 .remove() 로 리스트를 완전 탐색하는 코드를 삭제
 */
class Solution {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var result = 0
        val n = grid.size
        val m = grid[0].size

        // n 과 m 이 3 미만일때 0 리턴
        if (n < 3 || m < 3) return 0

        for (i in 0 .. n - 3) {
            for (j in 0 .. m - 3) {
                if (isMagic(grid, i, j)) result++
            }
        }

        return result
    }

    private fun isMagic(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        val seen = BooleanArray(10)

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val num = grid[row + i][col + j]
                if (num !in 0..9 || seen[num]) return false
                seen[num] = true
            }
        }

        if (grid[row][col] + grid[row][col+1] + grid[row][col+2] != 15) return false
        if (grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2] != 15) return false
        if (grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2] != 15) return false

        if (grid[row][col] + grid[row+1][col] + grid[row+2][col] != 15) return false
        if (grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1] != 15) return false
        if (grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2] != 15) return false

        if (grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2] != 15) return false
        if (grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col] != 15) return false

        return true
    }
}
