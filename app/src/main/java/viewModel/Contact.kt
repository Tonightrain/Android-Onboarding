package viewModel

class Contact(val name: String, val phone: String?, val type: Type, val avatar: String?) {
    enum class Type(val rgb: Int) {
        TYPE_ITEM(0),
        TYPE_HEADER(1)
    }


    companion object {
        private var lastContactId = 0
        fun createContactsList(numContacts: Int): ArrayList<Contact> {
            val url :String= "https://loremflickr.com/180/180?lock="
            val contacts = ArrayList<Contact>()
            val headerContact = Contact("This is header", null, Type.TYPE_HEADER,null)
            contacts.add(headerContact)
            for (i in 1..numContacts) {
                contacts.add(Contact("Person " + ++lastContactId, "1388637666$i", Type.TYPE_ITEM,"$url$i"))
            }
            return contacts
        }
    }
}




