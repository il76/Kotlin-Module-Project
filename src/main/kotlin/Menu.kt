import java.util.ArrayList
import java.util.Scanner


class Menu {
    val actions: MutableMap<Int, String> = mutableMapOf()

    /**
     * На какой мы вложенности?
     * 0 - архивы
     * 1 - заметки
     * < 0 - флаг выхода из программы
     */
    var currentLevel = 0
    /**
     * Чтение целочисленного ввода для пунктов меню
     */
    fun readMenuInput(): Int {
        return Scanner(System.`in`).nextInt()
    }

    /**
     * Чтение текстового ввода
     */
    fun readUserInput(): String {
        return Scanner(System.`in`).nextLine()
    }

    /**
     * Генерация пунктов меню
     */
    fun createEntries(list: ArrayList<out BasicRecord>, entryType: String) {
        actions.clear()
        actions.put(0, "Создать $entryType")
        var i = 0;
        for (item in list) {
            //println(item)
            actions.put(++i, item.name)
        }
        actions.put(actions.size, "Выход")
    }

    /**
     * Вывод меню на экра
     */
    fun printActions() {
        for ((item, action) in actions) {
            println("$item. $action")
        }
    }
}