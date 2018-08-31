package q885_Spiral_Matrix_3

/**
 * 两数之和
 *
 * https://leetcode-cn.com/problems/spiral-matrix-iii/description/
 *
 * @author fanhl
 */
object Q885 {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        find(solution, 1, 4, 0, 0)
    }

    private fun find(solution: Solution, R: Int, C: Int, r0: Int, c0: Int) {
        val result = solution.spiralMatrixIII(R, C, r0, c0)
        println("(R=$R,C=$C,r0=$r0,c0=$c0) => $result")
    }

    class Solution {
        fun spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
            val list = ArrayList<IntArray>()

            //当前巷子长度
            val length = 1
            //当前方向
            val direction = 0b0 % 0b100
            //在当前巷子中走了几步了
            var step = 0
            //当前位置
            var r = r0
            var c = c0

            while (step <= length) {
                list.add(intArrayOf(r, c))

                step++
                r
            }

            return list.toArray<IntArray>(arrayOfNulls(R * C))
        }
    }
}