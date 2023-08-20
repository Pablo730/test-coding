package _1_string._7_회문_문자열

fun solution (string: String): String {
	val str = string.uppercase()
	for (i in 0..str.length / 2) {
		if (str[i] != str[str.length - 1 - i]) {
			return "NO"
		}
	}
	return "YES"
}

fun main(): Unit {
	println(solution("gooG"))
}