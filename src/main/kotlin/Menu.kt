import java.util.Scanner

class Menu {
    val actions: MutableMap<Int, String> = mutableMapOf()
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

    fun createExitEntry() {
        actions.put(actions.size, "Выход")
    }
}