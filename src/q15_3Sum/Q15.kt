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

//        test(solution, arrayListOf(-1, 0, 1, 2), -3)
//        test(solution, arrayListOf(-1, 0, 1, 2), -2)
//        test(solution, arrayListOf(-1, 0, 1, 2), -1)
//        test(solution, arrayListOf(-1, 0, 1, 2), 0)
//        test(solution, arrayListOf(-1, 0, 1, 2), 1)
//        test(solution, arrayListOf(-1, 0, 1, 2), 2)
//        test(solution, arrayListOf(-1, 0, 1, 2), 3)
    }

    private fun test(solution: Solution, list: ArrayList<Int>, item: Int) {
        print("$list+$item")
        solution.test(list, item)
        println("->$list")
    }

    private fun find(solution: Solution, nums: IntArray) {
        val result = solution.threeSum(nums)
        println("${nums.toList()}=> $result")
    }

    class Solution {
        fun threeSum2(nums: IntArray): List<List<Int>> {
            val lists = ArrayList<List<Int>>()

            if (nums.size >= 3) {
                val find2List = arrayListOf(nums[0])
                addSorted(find2List, nums[1])


            }

            return lists
        }

        /**
         * 插入并排序（二分）
         */
        private fun addSorted(list: ArrayList<Int>, item: Int) {
            var l = 0
            var r = list.size - 1

            do {
                if (l < r) {
                    val m = (l + r) / 2
                    if (list[m] < item) {
                        l = m + 1
                    } else if (list[m] == item) {
                        list.add(m, item)
                        return
                    } else {
                        r = m - 1
                    }
                } else if (l == r) {
                    if (item < list[r]) {
                        list.add(r, item)
                    } else {
                        list.add(r + 1, item)
                    }
                    return
                } else {
                    list.add(r + 1, item)
                    return
                }
            } while (l <= r)
        }

        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()

            val lists = ArrayList<List<Int>>()

            for (pl in 0..(nums.size - 1 - 2)) {
                for (pm in (pl + 1)..(nums.size - 1 - 1)) {
                    val numR = -nums[pl] - nums[pm]
                    val pr = indexOfSorted(nums, pm + 1, nums.size - 1, numR)
                    if (pr >= 0) {
                        lists.add(listOf(nums[pl], nums[pm], nums[pr]))
                    }
                }
            }

            return lists.distinct()
        }

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

        fun test(list: ArrayList<Int>, item: Int) {
            addSorted(list, item)
        }
    }
}