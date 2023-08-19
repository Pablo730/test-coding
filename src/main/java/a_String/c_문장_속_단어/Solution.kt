package a_String.c_문장_속_단어

import java.util.*

fun solution(string: String): String {
	val stringArray: List<String> = string.split(" ")
	var int: Int = 0
	var answer: String = ""
	for (str in stringArray) {
		if (int < str.length) {
			int = str.length
			answer = str
		}
	}
	return answer
}
fun main(): Unit {
	println(solution(Scanner(System.`in`).nextLine()))
}