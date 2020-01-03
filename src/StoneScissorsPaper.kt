fun main(args:Array<String>) {

    val options = arrayOf("Камень", "Ножницы", "Бумага")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random()* optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String{

    var isValidChoice = false //проверка, ввел ли пользователь допустимый вариант

    var userChoice = " "

    while (!isValidChoice) {

        print("Пожалуйста, введите один из следующих вариантов: ")
        for (item in optionsParam) print(" $item")
        println(".")

        val userInput = readLine() //прочитать пользовательский ввод

        if(userInput !=null && userInput in optionsParam) {
            isValidChoice = true //цикл прерывается, если пользователь ввел допустимый вариант
            userChoice = userInput
        }

        //вывести сообщение, если пользователь ввел недопустимый вариант
        if (!isValidChoice) println ("Пожалуйста, введите корректный вариант")
    }

    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {

    val result: String

    //сравнить ввод пользователя и выбор игры

    if(userChoice == gameChoice) result = "Ничья!"
    else if ((userChoice == "Камень" && gameChoice == "Ножницы") ||
            (userChoice == "Бумага" && gameChoice == "Камень") ||
            (userChoice == "Ножницы" && gameChoice == "Бумага")) result = "Поздравляем! Вы выиграли!"

    else result = "Упс! Вы проиграли!"
            //Вывести результат

    println ("Вы выбрали $userChoice. Мы выбрали $gameChoice. $result")
}