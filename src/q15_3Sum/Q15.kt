package q1_TwoSum

/**
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * @author fanhl
 */
object Q15 {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        find(solution, intArrayOf(-1, 0, 1, 2, -1, -4))
    }

    private fun find(solution: Solution, nums: IntArray) {
        val result = solution.threeSum(nums)
        println("${nums.toList()}=> $result")
    }

    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()

            val lists = ArrayList<List<Int>>()

            for (pl in 0..(nums.size - 1 - 2)) {
                for (pm in (pl + 1)..(nums.size - 1 - 1)) {
                    for (pr in (pm + 1)..(nums.size - 1)) {
                        if (nums[pl] + nums[pm] + nums[pr] == 0) {
                            lists.add(listOf(nums[pl], nums[pm], nums[pr]))
                        }
                    }
                }
            }

            return lists.distinct()
        }
    }
}