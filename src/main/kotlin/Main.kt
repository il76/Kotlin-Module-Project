fun main(args: Array<String>) {
    println("Записная книжка")
    println("Выберите пункт меню для начала работы")
    val menu = Menu()
    val archivesList: ArrayList<Archive> = ArrayList()

    /**
     * Что ввёл польлзователь?
     */
    var userInput: Int

    /**
     * запоминаем выбранный архив
     */
    var curArchiveNum = 0

    while (true) {
        if (menu.currentLevel == 0) {
            println("\nГлавное меню. Список архивов")
            menu.createEntries(archivesList, Archive.CREATE)
        } else {
            val archive = archivesList[curArchiveNum]
            println("\nПросмотр архива \"${archive.name}\"")
            menu.createEntries(archive.notesList, Note.CREATE)
        }
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
                    archivesList[curArchiveNum].notesList.add(Note(name, content))
                }
            } else if (!failedValidation) {
                archivesList.add(Archive(name))
            }
        } else { //просмотр
            if (menu.currentLevel == 0) { //вход в архив
                curArchiveNum = userInput - 1
                menu.currentLevel++
            } else { // просмотр заметки
                val note = archivesList[curArchiveNum].notesList[userInput-1]
                println("Просмотр заметки № $userInput из архива "+ archivesList[curArchiveNum].name)
                println("Название: \n${note.name}")
                println("Содержание: \n${note.content}")
            }
        }
    }
    println("До свидания")
}