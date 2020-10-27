package viewModel

class Contact(val name: String, val phone: String) {
    companion object{
        private var lastContactId = 0
        fun createContactsList(numContacts:Int):ArrayList<Contact>{
            val contacts = ArrayList<Contact>()
            for(i in 1..numContacts){
                contacts.add(Contact("Person "+ ++lastContactId, "1388637666$i"))
            }
            return contacts
        }
    }
}
