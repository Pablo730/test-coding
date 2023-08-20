package _1_string._4_단어_뒤집기

import java.util.*

fun solution (stringList: List<String>): List<String> {
	val answer: MutableList<String> = ArrayList(stringList.size)
	for (string in stringList) {
		answer.add(string.reversed())
	}
	return answer
}
fun main(): Unit {
	val scanner: Scanner = Scanner(System.`in`)
	val int: Int = scanner.nextInt()
	val stringList: MutableList<String> = ArrayList(int)
	for (i in 1..int) {
		stringList.add(scanner.next())
	}
	for (string in solution(stringList)) {
		println(string)
	}
}