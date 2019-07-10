package revert.array

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the revert.array.reverseArray function below.
fun reverseArray(a: Array<Int>): Array<Int> {
    a.reverse()
    return a
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arrCount = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}
