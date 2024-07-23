fun main(args: Array<String>) {
    println("Записная книжка")
    println("Выберите пункт меню для начала работы")
    val menu = Menu()
    val archivesList: ArrayList<Archive> = ArrayList()
    var userInput: Int
    var curArchiveNum = 0

    menu.createEntries(archivesList, Archive.CREATE)


    while (true) {
        menu.printActions()
        try {
            userInput = menu.readMenuInput()
        } catch (e: Exception) {
            println("Пожалуйста, введите число")
            continue
        }
        if (!menu.actions.containsKey(userInput)) {
            println("Такого пункта нет, выберите корректный")
            continue
        } else if (userInput == menu.actions.size-1) { //выход всегда последний пункт
            println("Выходим на предыдущий уровень меню")
            menu.currentLevel--
            if (menu.currentLevel < 0) {
                break
            }
            menu.createEntries(archivesList, Archive.CREATE)
        } else if (userInput == 0) { // создание всегда первый пункт
            val text = when (menu.currentLevel) {
                0 -> Archive.WHAT
                else -> Note.WHAT
            }
            println("Укажите название $text")
            val name = menu.readUserInput()
            var failedValidation = false
            if (name.isEmpty()) {
                println("Название $text не может быть пустым")
                failedValidation = true
            }
            if (!failedValidation and (menu.currentLevel == 1)) {
                println("Введите содержимое $text")
                val content = menu.readUserInput()
                if (content.isEmpty()) {
                    println("Содержимое $text не может быть пустым")
                } else {
                    archivesList.get(curArchiveNum).notesList.add(Note(name, content))
                    menu.createEntries(archivesList.get(curArchiveNum).notesList, Note.CREATE)
                }
            } else if (!failedValidation) {
                archivesList.add(Archive(name))
                menu.createEntries(archivesList, Archive.CREATE)
            }
        } else { //просмотр
            if (menu.currentLevel == 0) {
                curArchiveNum = userInput - 1
                val archive = archivesList.get(curArchiveNum)
                println("\nПросмотр архива \"${archive.name}\"")
                menu.createEntries(archive.notesList, Note.CREATE)
                menu.currentLevel++
            } else {
                val note = archivesList.get(curArchiveNum).notesList.get(userInput-1)
                println("Просмотр заметки № $userInput из архива "+archivesList.get(curArchiveNum).name)
                println("Название: \n${note.name}")
                println("Содержание: \n${note.content}")
            }
        }
    }
    println("До свидания")
}