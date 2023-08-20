package _1_string._6_중복_문자_제거

fun solution (str: String): String {
	var answer = ""
	val set: MutableSet<Char> = mutableSetOf()
	for (i in str.indices) {
		if (!set.contains(str[i])) {
			answer += str[i]
			set.add(str[i])
		}
	}
	return answer
}

fun main(): Unit {
	println(solution("ksekkkkk1kseta"))
}