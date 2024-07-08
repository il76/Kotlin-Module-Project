fun main(args: Array<String>) {
    println("Записная книжка")
    println("Выберите пункт меню для начала работы")
    val menu = Menu()
    menu.actions.put(0, "Создать архив")
    menu.createExitEntry()

    val archivesList = ArchivesList()
    var userInput: Int
    while (true) {
        for ((item, action) in menu.actions) {
            println("$item. $action")
        }
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
            println("Выходим")
            break
        } else if (userInput == 0) { // создание всегда первый пункт
            println("Укажите название архива")
            val name = menu.readUserInput()
            if (name.isEmpty()) {
                println("Название архива не может быть пустым")
            } else {
                archivesList.add(Archive(name))
                menu.actions.replace(menu.actions.size-1, name)
                menu.createExitEntry()
            }
        } else { //просмотр архива
            val archive = archivesList.archivesList.get(userInput)
            for (note in archive.notesList) {

            }
            //for (note in archivesList)
        }
    }
    println("До свидания")
}