package a_String.a_문자찾기

import java.util.*

fun solution(string: String, char: Char): Int {
	var int: Int = 0
	val cUpper: Char = char.uppercaseChar()
	for (c in string.uppercase()) {
		if (c == cUpper) {
			int++
		}
	}
	return int
}

fun main(): Unit {
	val scanner: Scanner = Scanner(System.`in`)
	println(solution(scanner.next(), scanner.next()[0]))
}