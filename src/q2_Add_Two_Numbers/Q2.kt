package q2_Add_Two_Numbers

import java.math.BigDecimal

/**
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * @author fanhl
 */
object Q2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

//        find(solution, "5", "5")
        find(solution, "342", "465")
//        find(solution, "999999999", "999999999")
    }

    private fun find(solution: Solution, num1: String, num2: String) {
        val l1 = num2node(BigDecimal(num1))
        val l2 = num2node(BigDecimal(num2))

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

    fun num2node(num: BigDecimal): ListNode? {
        var node: ListNode? = null
        num.toString().map { it.toString().toInt() }.forEach {
            node = ListNode(it).apply { next = node }
        }
        return node
    }

    class Solution {
        fun addTwoNumbers(node1: ListNode?, node2: ListNode?): ListNode? {
            fun add(node1: ListNode?, node2: ListNode?, carry: Int = 0): ListNode? {
                val result = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry

                return ListNode(result % 10).apply {
                    if (node1?.next != null || node2?.next != null || result / 10 > 0) {
                        next = add(node1?.next, node2?.next, result / 10)
                    }
                }
            }

            return add(node1, node2)
        }
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}

