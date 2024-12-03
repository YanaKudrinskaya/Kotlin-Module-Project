import com.sun.tools.javac.Main
import java.util.Scanner

fun main() {

    val app = appNotes()
    app.start()
}

class appNotes {
    val scanner = Scanner(System.`in`)
    val archives: MutableList<Archive> = mutableListOf()
    var activeMenu = Menu("Список архивов:", createMainMenu(archives))

    fun start() {
        while(true) {
            activeMenu.show()
            println("Введите номер меню")
            val message = scanner.nextLine()
            activeMenu.selectItem(message)
        }
    }

    fun createMainMenu(list: MutableList<Archive>): List<ItemMenu> {
        val items = mutableListOf<ItemMenu>()
        items.add(ItemMenu("Создать архив", {createArсhive()}))
        if(list.isNotEmpty()) {
            for(element in list) items.add(ItemMenu(element.name, {activeMenu = Menu("Список заметок в архиве ${element.name}", createArchiveMenu(element))}))
        }
        items.add(ItemMenu("Выход", {exitApp()}))
        return items
    }

    fun createArchiveMenu(archive: Archive): List<ItemMenu> {
        val items = mutableListOf<ItemMenu>()
        items.add(ItemMenu("Создать заметку", {createNote(archive)}))
        if(archive.listNotes.isNotEmpty()) {
            for(element in archive.listNotes) items.add(ItemMenu(element.name, {element.showNote()}))
        }
        items.add(ItemMenu("Назад", {activeMenu = Menu("Список архивов:", createMainMenu(archives))}))
        return items
    }

    private fun createNote(archive: Archive) {
        archive.addNote()
        activeMenu = Menu("Список заметок в архиве ${archive.name}", createArchiveMenu(archive))
    }
     private fun createArсhive() {
         var name = readUserInput("Введите название архива: ")
         archives.add(Archive(name))
         println("$name создан")
         activeMenu = Menu("Список архивов:", createMainMenu(archives))
     }

    private fun exitApp() {
        println("Выход")
        System.exit(0)
    }
}

