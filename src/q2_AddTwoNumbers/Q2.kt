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

        find(solution, 342L, 465L)
        find(solution, 999999999L, 999999999L)
    }

    private fun find(solution: Solution, num1: Long, num2: Long) {
        val l1 = solution.num2node(num1)
        val l2 = solution.num2node(num2)

        val result = solution.addTwoNumbers(l1, l2)

        println("${str(l1)}+${str(l2)}=${str(result)}")
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
            val nL1 = node2num(l1 ?: return null)
            val nL2 = node2num(l2 ?: return null)

            return num2node(nL1 + nL2)
        }

        private fun node2num(listNode: ListNode): Long {
            return listNode.`val` + (listNode.next?.let { 10 * node2num(it) } ?: 0)
        }

        fun num2node(num: Long): ListNode? {
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

