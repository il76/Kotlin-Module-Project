data class Archive(override val name: String): BasicRecord() {
    val notesList: ArrayList<Note> = ArrayList()
    override fun validate(): Boolean {
        return name.isNotEmpty()
    }

    companion object {
        const val CREATE = "архив"
        const val WHAT = "архива"
    }
}