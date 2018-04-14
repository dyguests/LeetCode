package q2_AddTwoNumbers

/**
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * @author fanhl
 */
object Q2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        find(solution, 342, 465)
    }

    private fun find(solution: Solution, num1: Int, num2: Int) {
        val l1 = solution.node(num1)
        val l2 = solution.node(num2)

        val result = solution.addTwoNumbers(l1, l2)

        println("${str(l1)}+${str(l2)}+${str(result)}")
    }

    private fun str(listNode: ListNode?): String {
        var tmpNode = listNode

        val sb = StringBuilder("(")

        while (tmpNode?.`val` != null) {
            sb.append(tmpNode.`val`)
            tmpNode = tmpNode.next

            if (tmpNode?.`val` != null) {
                sb.append(" -> ")
            }
        }

        sb.append(")")

        return sb.toString()
    }

    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            val nL1: Int = listNode2Number(l1 ?: return null)
            val nL2: Int = listNode2Number(l2 ?: return null)

            return node(nL1 + nL2)
        }

        private fun listNode2Number(listNode: ListNode): Int {
            return listNode.`val` + (listNode.next?.let { 10 * listNode2Number(it) } ?: 0)
        }

        fun node(num: Int): ListNode? {
            var node: ListNode? = null
            num.toString().map { it.toString().toInt() }.forEach {
                node = ListNode(it).apply { next = node }
            }
            return node
        }
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}

