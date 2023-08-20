package _1_string._5_특정_문자_뒤집기

import java.util.*

fun solution(string: String): String {
	val charArray: CharArray = string.toCharArray()

	var left: Int = 0
	var right: Int = charArray.size - 1

	while (left < right) {
		if (!charArray[left].isLetter()) {
			left++
			continue
		}

		if (!charArray[right].isLetter()) {
			right--
			continue
		}

		val tempC: Char = charArray[left]
		charArray[left] = charArray[right]
		charArray[right] = tempC
		left++
		right--
	}

	return String(charArray)
}
fun main(): Unit {
	println(solution(Scanner(System.`in`).next()))
}