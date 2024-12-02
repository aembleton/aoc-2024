fun main() {

Day02.part1(readInput("d2p1")).println()
    Day02.part2(readInput("d2p2")).println()
}

object Day02 {
    fun part1(input: List<String>): Int {
        return input.map { it.split(" ").map { it.toInt() } }
            .map { if (it.allIncreasing()  || it.allDecreasing()) 1 else 0}
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input.map { it.split(" ").map { it.toInt() } }
            .sumOf { if (it.allIncreasing() || it.allDecreasing()) 1 else dampener(it) }
    }

    private fun dampener(numbers:List<Int>):Int {
        for (i in numbers.indices) {
            val row = numbers.subList(0, i) + numbers.subList(i + 1, numbers.size)
            if (row.allIncreasing() || row.allDecreasing()) {
                return 1
            }
        }
        return 0
    }

    private fun List<Int>.allIncreasing(): Boolean = when {
        size < 2 -> true
        else -> get(1) - first() in 1..3  && drop(1).allIncreasing()
    }

    private fun List<Int>.allDecreasing(): Boolean = when {
        size < 2 -> true
        else -> first() - get(1) in 1..3 && drop(1).allDecreasing()
    }
}