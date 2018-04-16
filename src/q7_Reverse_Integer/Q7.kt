package q7_Reverse_Integer

import kotlin.math.absoluteValue

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
        find(solution, 12)
        find(solution, 123)
        find(solution, -123)
        find(solution, -0)
        find(solution, -210)
        find(solution, 210)
    }

    private fun find(solution: Solution, x: Int) {
        val result = solution.reverse(x)
        println("$x => $result")
    }

    class Solution {
        fun reverse(x: Int): Int {
            return try {
                Math.abs(x).toString().reversed().toInt() * if (x >= 0) 1 else -1
            } catch (e: NumberFormatException) {
                0
            }
        }
    }
}