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
        find(solution, 0, 1, 4, 2, 3, 5)
    }

    private fun find(solution: Solution, vararg row: Int) {
        val result = solution.minSwapsCouples(row)
        println("${row.asList()} => $result")
    }


    class Solution {
        fun minSwapsCouples(row: IntArray): Int {
            var times = row.size / 2
            val list = row.toMutableList()

            var circleStart: Int? = null
            var circleEnd: Int? = null
            while (list.isNotEmpty()) {
                if (isCouple(list[0], list[1])) {
                    list.removeAll(list.slice(0..1))
                    times -= 1
                    continue
                }
                if (circleStart == null || circleEnd == null) {
                    circleStart = list[0]
                    circleEnd = list[1]
                    list.removeAll(list.slice(0..1))
                    continue
                }
                val newCircleEndIndex = list.indexOf(circleEnd xor 1)
                circleEnd = list[newCircleEndIndex xor 1]
                val newCoupleIndexStart = newCircleEndIndex - newCircleEndIndex % 2
                list.removeAll(list.slice(newCoupleIndexStart..(newCoupleIndexStart + 1)))

                if (isCouple(circleStart, circleEnd)) {
                    circleStart = null
                    circleEnd = null
                    times -= 1
                }
            }
            return times
        }

        private fun isCouple(people1: Int, people2: Int): Boolean {
            return people1 != people2 && people1 / 2 == people2 / 2
        }
    }
}