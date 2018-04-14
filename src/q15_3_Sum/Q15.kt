package q1_Two_Sum

import kotlin.collections.ArrayList

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
        find(solution, intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0))
    }

    private fun find(solution: Solution, nums: IntArray) {
        val result = solution.threeSum(nums)
        println("${nums.toList()}=> $result")
    }

    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()
            val numsDistinct3 = distinct3(nums)

            val lists = ArrayList<List<Int>>()

            for (pl in 0..(numsDistinct3.size - 1 - 2)) {
                for (pm in (pl + 1)..(numsDistinct3.size - 1 - 1)) {
                    val numR = -numsDistinct3[pl] - numsDistinct3[pm]
                    val pr = indexOfSorted(numsDistinct3, pm + 1, numsDistinct3.size - 1, numR)
                    if (pr >= 0) {
                        lists.add(listOf(numsDistinct3[pl], numsDistinct3[pm], numsDistinct3[pr]))
                    }
                }
            }

            return lists.distinct()
        }

        /**
         * 对有序数组进行查找
         */
        private fun indexOfSorted(nums: IntArray, start: Int, end: Int, item: Int): Int {
            var l = start
            var r = end

            do {
                val m = (l + r) / 2
                when {
                    nums[m] < item -> l = m + 1
                    nums[m] > item -> r = m - 1
                    else -> return m
                }
            } while (l <= r)
            return -1
        }

        /**
         * 将重复超过3次的数字去掉多余的次数（最多重复三次）
         */
        private fun distinct3(nums: IntArray): IntArray {
            if (nums.size <= 3) {
                return nums.copyOf()
            }
            val list = arrayListOf(nums[0], nums[1], nums[2])

            (3..(nums.size - 1)).forEach {
                val item = nums[it]
                if (item != list[list.size - 3] || item != list[list.size - 2] || item != list[list.size - 1]) {
                    list.add(item)
                }
            }

            return list.toIntArray()
        }
    }
}