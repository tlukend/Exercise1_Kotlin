package com.example.firstproject

var randomNumber4Digits = generateRandom()
var userInput = ""


fun main () {
        //println(randomNumber4Digits)
    while (randomNumber4Digits != userInput) { // as long as input and random are not the same, do:
        println("Type in your guessed 4-digit number with non-repeating numbers: ")
        userInput = readLine().toString()
        if (randomNumber4Digits == userInput) {
            println("You've got it right")
        } else println("You didn't get it right, try again")

        val seperatedNumbers = userInput.split("").filter { it.length == 1 }
        //println(seperatedNumbers)

        val guessedCorrectly = checkIfContains(seperatedNumbers, randomNumber4Digits)
        val guessedCorrectlyInOrder = checkIfContainsOnCertainSpot(randomNumber4Digits, seperatedNumbers)
        println("User input: $userInput, Output: $guessedCorrectly :  $guessedCorrectlyInOrder")
    }
}
fun generateRandom () : String {
    var rn = ""
    var rnew = (0..9).random().toString()
    for (i in 0..3) {
        if (rn.contains(rnew)) {
            while(rn.contains(rnew)) { rnew = (0..9).random().toString() }
        } else return rn
        rn += rnew
    }
    return rn
}


fun checkIfContains (inputList: List<String>, random: String)  :Int {
    var result = 0 //declare result variable, but a changeable one
    for (i in inputList){ // iterate through user input
        if (random.contains(i)){ //check if random numbers contain that element from input list
            result ++ // increase result number
        }
    }
    return result
}

fun checkIfContainsOnCertainSpot (random: String, input: List<String>) :Int { // parameter is the generated random number
    var index = 0
    var result = 0
    val randomlist = random.split("").filter { it.length == 1 } //splits random number into an arraylist
    for (i in randomlist){ // iterates through list of random numbers
        if (i == input.elementAt(index)) { //if the element on both indices are the same
            result++ //number of results grows
            index++ // next index will be checked and follow "i"
        }
        else index ++
        }
    return result
}



