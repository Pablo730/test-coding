package _1_string._8_유효한_팰린드롬

fun solution(str: String): String {
	val string: String = str.uppercase()
	for (i in 0..string.length / 2) {
		if (string[i].isLetter() &&
			string[string.length - 1 - i].isLetter() &&
			string[i].isLetter() != string[string.length - 1 - i].isLetter()) {
			return "NO"
		}
	}
	return "YES"
}

fun main(): Unit {
	println(solution("found7, time: study; Yduts; emit, 7Dnuof"))
}