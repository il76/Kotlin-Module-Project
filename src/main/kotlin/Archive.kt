data class Archive(override val name: String): BasicRecord(name) {
    val notesList: ArrayList<Note> = ArrayList()

    companion object {
        const val CREATE = "архив"
        const val WHAT = "архива"
    }
}