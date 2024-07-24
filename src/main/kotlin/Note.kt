data class Note(override val name: String, val content: String): BasicRecord(name) {
    companion object {
        const val CREATE = "заметку"
        const val WHAT = "заметки"
    }
}