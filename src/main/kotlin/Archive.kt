class Archive(val name: String) {
    val listNotes: MutableList<Note> = mutableListOf()
    override fun toString(): String {
        return name
    }

    fun addNote() {
        val name = readUserInput("Введите название заметки: ")
        val body = readUserInput("Введите заметку: ")
        println("Заметка $name создана")
        listNotes.add(Note(name, body))
    }
}