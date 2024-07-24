import java.util.ArrayList
import java.util.Scanner


class Menu {
    /**
     * Пункты меню на текущем уровне вложенности
     */
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
        actions[0] = "Создать $entryType"
        for ((i, item) in list.withIndex()) {
            actions[i + 1] = item.name
        }
        actions[actions.size] = "Выход"
    }

    /**
     * Вывод меню на экран
     */
    fun printActions() {
        for ((item, action) in actions) {
            println("$item. $action")
        }
        println("Выберите пункт меню [0..${actions.size-1}]")
    }
}