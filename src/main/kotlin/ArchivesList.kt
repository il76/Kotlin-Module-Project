class ArchivesList {
    val archivesList: ArrayList<Archive> = ArrayList()

    fun add(acrhive: Archive) {
        archivesList.add(acrhive)
    }

    fun list(): ArrayList<Archive> {
        return archivesList
    }
}