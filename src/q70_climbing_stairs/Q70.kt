package q70_climbing_stairs

/**
 * 两数之和
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author fanhl
 */
object Q70 {
    private val solution = Solution()

    @JvmStatic
    fun main(args: Array<String>) {
        print(1)
        print(2)
        print(3)
        print(4)
    }

    private fun print(n: Int) {
        println("$n : ${solution.climbStairs(n)}")
    }

    class Solution {
        fun climbStairs(n: Int): Int {
            var n = n - 1
            val kinds = arrayOf(1, 2)
            while (n > 1) {
                kinds[n % 2] += kinds[(n - 1) % 2]
                n--
            }
            return kinds[n]
        }
    }
}