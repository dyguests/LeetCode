package q7_Reverse_Integer

/**
 * 反转整数
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * @author fanhl
 */
object Q7 {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        find(solution, 1)
    }

    private fun find(solution: Solution, x: Int) {
        val result = solution.reverse(x)
        println("$x => $result")
    }

    class Solution {
        fun reverse(x: Int): Int {
            return x
        }
    }
}