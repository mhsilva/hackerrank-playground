package garys.valley

fun countingValleys(n: Int, s: String): Int {

    var level = 0
    var previousLevel = 0
    var valleyCount = 0

    for (letter in s) {
        previousLevel = level
        level +=
        if ('D' == letter)
            -1
        else
            1
        if (previousLevel < 0 && level == 0)
            valleyCount++
    }

    return valleyCount
}

fun main() {
    println(countingValleys(8, "UDDDUDUU"));
}