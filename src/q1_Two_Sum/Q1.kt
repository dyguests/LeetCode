package q1_Two_Sum

/**
 * 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * @author fanhl
 */
object Q1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        find(solution, intArrayOf(1, 3, 4), 5)
        find(solution, intArrayOf(1, 2, 2, 3, 4), 5)
        find(solution, intArrayOf(2, 7, 11, 15), 9)
    }

    private fun find(solution: Solution, nums: IntArray, target: Int) {
        val result = solution.twoSum(nums, target).toList()
        println("${nums.toList()}->$target => $result")
    }

    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            for (p1 in 0..(nums.size - 2)) {
                for (p2 in (p1 + 1)..(nums.size - 1)) {
                    if (nums[p1] + nums[p2] == target) {
                        return intArrayOf(p1, p2)
                    }
                }
            }
            return intArrayOf(0, 1)
        }
    }
}