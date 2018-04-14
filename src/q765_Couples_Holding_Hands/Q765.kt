package q765_Couples_Holding_Hands

/**
 * 情侣牵手
 *
 * https://leetcode-cn.com/problems/couples-holding-hands/description/
 *
 * @author fanhl
 */
object Q765 {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        find(solution, 0, 1)
        find(solution, 0, 1, 2, 3)
        find(solution, 0, 2, 1, 3)
        find(solution, 3, 2, 0, 1)
    }

    private fun find(solution: Solution, vararg row: Int) {
        val result = solution.minSwapsCouples(row)
        println("$row => $result")
    }

    class Solution {
        fun minSwapsCouples(row: IntArray): Int {
            val sorted = isSorted(row)
            println(sorted)
            return 0
        }

        private fun isSorted(row: IntArray): Boolean {
            for (index in row.indices step 2) {
                if (!isCouple(row, index)) return false
            }
            return true
        }

        private fun isCouple(row: IntArray, index: Int): Boolean {
            return isCouple2(row[index - index % 2], row[index - index % 2 + 1])
        }

        private fun isCouple2(people1: Int, people2: Int): Boolean {
            return people1 != people2 && people1 / 2 == people2 / 2
        }
    }
}