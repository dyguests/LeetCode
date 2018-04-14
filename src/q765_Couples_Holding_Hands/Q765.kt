package q765_Couples_Holding_Hands

/**
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
            return 0
        }
    }
}