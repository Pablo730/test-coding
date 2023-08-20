package _1_string._2_대소문자변환


import java.util.*

fun solution(string: String): String {
	val charArray: CharArray = CharArray(string.length)
	var int: Int = 0
	for (c in string) {
		if (c.isLowerCase()) {
			charArray[int++] = c.uppercaseChar()
			continue
		}
		charArray[int++] = c.lowercaseChar()
	}
	return String(charArray)
}
fun main(): Unit {
	println(solution(Scanner(System.`in`).next()))
}