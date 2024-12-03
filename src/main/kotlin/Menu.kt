import java.util.Scanner

class Menu (val header: String, val listItems: List<ItemMenu>){
    private val scanner = Scanner(System.`in`)

    fun show() {
        println(header)
        listItems.forEachIndexed { index, item -> println("${index}. ${item.label}")
        }
    }

    fun selectItem(input: String) {
        val itemNumber = input.toIntOrNull()
        if(itemNumber != null && itemNumber in 0 .. listItems.size-1) {
            listItems[itemNumber].action()
        } else println("Введите верный номер меню")
    }


}