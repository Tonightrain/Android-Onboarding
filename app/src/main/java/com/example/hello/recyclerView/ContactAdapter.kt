package com.example.hello.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hello.R
import viewModel.Contact

//class ContactsAdapter(private val mContacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
//
//    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
//        val nameTextView: TextView = itemView.findViewById<TextView>(R.id.contact_name)
//        val phoneTextView: TextView = itemView.findViewById(R.id.contact_phone)
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val context = parent.context
//        val inflater = LayoutInflater.from(context)
//        val contactView = inflater.inflate(R.layout.item_contact, parent, false)
//        return ViewHolder(contactView)
//
//    }
//
//    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
//        val contact: Contact = mContacts[position]
//        val textView = viewHolder.nameTextView
//        val textView1 = viewHolder.phoneTextView
//        textView.text = contact.name
//        textView1.text = contact.phone
//    }
//
//    override fun getItemCount(): Int {
//        return mContacts.size
//    }
//}

class ContactsAdapter(private val mContacts: List<Contact>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolderText(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val nameTextView: TextView = itemView.findViewById<TextView>(R.id.contact_name)
        val phoneTextView: TextView = itemView.findViewById(R.id.contact_phone)
    }

    inner class ViewHolderHeader(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val headerTextView: TextView = itemView.findViewById<TextView>(R.id.contact_header)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0){
            ViewHolderText(LayoutInflater.from(parent.context).inflate(R.layout.item_contact_header, parent, false))
        }else{
            ViewHolderHeader(LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact: Contact = mContacts[position]
        if (getItemViewType(position) == 1){
            val textView = (holder as ViewHolderText).nameTextView
            val textView1 = holder.phoneTextView
            textView.text = contact.name
            textView1.text = contact.phone
        }else{
            val textView = (holder as ViewHolderHeader).headerTextView
            textView.text = contact.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mContacts[position].type == Contact.Type.TYPE_HEADER){
            0
        }else{
            1
        }
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }
}
