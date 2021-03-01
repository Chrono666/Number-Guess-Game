fun main() {
    val input = getUserInput()
    val userNumbers = userInputToList(input)
    val randomNumbers = generateRandomNumberList()
    val n = countCorrectGuesses(userNumbers, randomNumbers)
    val m = countCorrectPosition(userNumbers, randomNumbers)
    print("User input: $input, Output: $n:$m")
}

fun getUserInput(): String {
    var input = ""
    while (input.length != 4) {
        println("Please enter four numbers")
        input = readLine().toString()
        if (input.length < 4 || input.length > 4) {
            println("make sure to enter 4 numbers")
        }
    }
    return input
}

fun generateRandomNumberList(): MutableList<String> {
    val randomNumbers = mutableListOf<String>()
    while (randomNumbers.size < 4) {
        val randomInt = (0..9).random().toString()
        if (randomNumbers.contains(randomInt)) {
            continue
        } else {
            randomNumbers.add(randomInt)
        }
    }
    return randomNumbers
}

fun userInputToList(element: String): MutableList<String> {
    return (element.chunked(1)).toMutableList()
}

fun countCorrectPosition(userNumbers: MutableList<String>, randomNumbers: MutableList<String>): Number {
    var m = 0
    for (i in 0..3) {
        if (userNumbers[i] == randomNumbers[i]) {
            m++
        }
    }
    return m
}

fun countCorrectGuesses(userNumbers: MutableList<String>, randomNumbers: MutableList<String>): Number {
    var n = 0
    for (i in 0..3) {
        if (userNumbers.contains(randomNumbers[i])) {
            n++
        }
    }
    return n
}

