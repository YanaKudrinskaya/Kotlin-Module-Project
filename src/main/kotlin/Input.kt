import java.util.Scanner

fun readUserInput(message: String = ""): String {
    val scanner = Scanner(System.`in`)
    if (message.isNotEmpty()) {
        print(message)
    }
    var input = ""
    do{
        println("Строка не может быть пустой")
        input = scanner.nextLine().trim()
    } while(input.length == 0)
    return input
}