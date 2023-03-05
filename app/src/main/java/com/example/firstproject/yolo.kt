package com.example.firstproject

//var = changeable, val = constant
var name = "Tina"
var name1: String = "Tina"
var name2: String? = null
val howOldWillYouBeInTwoYears: (Int) -> Int = { num -> num + 2 }
val list = listOf<String>("Bruno", "Lala", "Anna", "Martin", "KingKong")
val sortedList = list.sorted()
val newList = sortedList.filter { it.contains('a') }.reversed()

var randomNumber4Digits = generateRandom()
var userInput = ""



fun generateRandom () : String {
    var rn = ""
    var rnew = (0..9).random().toString()
    for (i in 0..3) {
        if (rn.contains(rnew)) {
            while(rn.contains(rnew)) { rnew = (0..9).random().toString() }
        } else rnew = rnew
        rn = rn + rnew
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
        if (i == input.elementAt(index)) {
            result++
            index++
        }
        else index ++
        }
    return result
}


//idea for the user input: if I take all the digits extra, it could work easier
// fun checkposition, fun checkcorrectnumbers

fun main () {
//println(randomNumber4Digits)
    while (randomNumber4Digits != userInput) {
        println("Type in your guessed 4-digit number with non-repeating numbers: ")
        userInput = readLine().toString()
        if (randomNumber4Digits == userInput) {
            println("You've got it right")
        } else println("You didn't get it right, try again")

        val seperatedNumbers = userInput.split("").filter { it.length == 1 }
        //println(seperatedNumbers)

        val guessedCorrectly = checkIfContains(seperatedNumbers, randomNumber4Digits)
        val guessedCorrectlyInOrder =
            checkIfContainsOnCertainSpot(randomNumber4Digits, seperatedNumbers)
        println("User input: $userInput, Output: $guessedCorrectly :  $guessedCorrectlyInOrder")
    }
}



fun showHowYouAreStructuredNamed(name: String){
    println("Hello, this is $name 's Showcase")
}
fun showHowYouAreStructuredDefaultName(name: String = "Defaultina"){
    println("Hello, by default we have this name: $name")
}
/*
println("Hello World")
println(name2?.lowercase()) //skips everything
//println(name2!!.compareTo(name)) // run anyway
if (name2 == null) println("Oops. We can't find a name for this example")
else println(name2)

showHowYouAreStructuredNamed(name = name)

showHowYouAreStructuredDefaultName()
showHowYouAreStructuredDefaultName(name = "NotSoDefaultAnymore")


println("If you are 17 now, you will be $howOldWillYouBeInTwoYears(17)  in two years")


    println(list)
    println(sortedList)
    println(newList)

fun add (a: Double, b: Double): Double {
    return a + b
}
//expects two double values and one function that also expects 2dv & returns 1dv
fun higherOrder(a: Double, b:Double, fn: (Double, Double) -> Double) : Double {
    // a: b: input param, fn: input fn (input params. -> return type) : return type
    //print(fn(a,b))
    return fn(a,b) // return the function's return
}

    //store function as a variable in highFun
    val highFun = higherOrder(2.0, 3.0, ::add) //:: to pass a function inside a function
    println(highFun)



   // val max = max( strings, { a,b -> a.length < b.length })
 */