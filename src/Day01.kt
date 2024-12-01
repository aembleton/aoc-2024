fun main() {
    fun part1(input: List<String>): Int {
        val rows = input.map { it.split("   ") }
        val left = rows.map { it[0].toInt() }.sorted()
        val right = rows.map { it[1].toInt() }.sorted()
        return left.zip(right).sumOf { if (it.first < it.second) it.second-it.first else it.first-it.second }
    }

    fun part2(input: List<String>): Int {
        val rows = input.map { it.split("   ") }
        val left = rows.map { it[0].toInt() }.sorted()
        val right = rows.map { it[1].toInt() }.sorted()
        return left.sumOf { l -> right.count { it == l } * l }
    }



    part1(readInput("d1p1")).println()
    part2(readInput("d1p2")).println()
}
