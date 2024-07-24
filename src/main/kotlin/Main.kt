fun main(args: Array<String>) {
   App().apply { // группируем вызовы методов
        // приветствие
        init()
        // основной цикл
        useMenu()
        // вышли из меню, завершаем работу
        shutdown()
    }
}