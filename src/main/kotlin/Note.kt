data class Note(override val name: String, val content: String): BasicRecord() {
    override fun validate(): Boolean {
        return name.isNotEmpty() and content.isNotEmpty()
    }
    companion object {
        const val CREATE = "заметку"
        const val WHAT = "заметки"
    }
}