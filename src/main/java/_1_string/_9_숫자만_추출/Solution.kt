package _1_string._9_숫자만_추출

fun solution (str: String): Int {
	return str.filter { it.isDigit() }.toInt()
}

fun main(): Unit {
	println(solution("g0en2T0s8eSoft"))
}