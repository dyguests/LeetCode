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
        find(solution, 0, 1, 2, 4, 3, 5)
    }

    private fun find(solution: Solution, vararg row: Int) {
        val result = solution.minSwapsCouples(row)
        println("$row => $result")
    }


    class Solution {
        fun minSwapsCouples(row: IntArray): Int {
            val rowSimplified: IntArray = simplify(row)
            val sorted = isSorted(row)
            println(sorted)
            return 0
        }

        /**
         * 去掉已经成对的情侣
         */
        private fun simplify(row: IntArray): IntArray {
            return (row.indices step 2).filter { !isCouple(row, it) }
                    .map { listOf(row[it], row[it + 1]) }
                    .flatten()
                    .toIntArray()
        }

        private fun isSorted(row: IntArray): Boolean {
            return (row.indices step 2).any { isCouple(row, it) }
        }

        private fun isCouple(row: IntArray, index: Int): Boolean {
            return isCouple(row[index - index % 2], row[index - index % 2 + 1])
        }

        private fun isCouple(people1: Int, people2: Int): Boolean {
            return people1 != people2 && people1 / 2 == people2 / 2
        }

        /**
         * 取得这个人的另一半
         */
        private fun findCouple(people: Int): Int {
            return people xor 1
        }
    }
}