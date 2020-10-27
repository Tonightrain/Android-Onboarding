package com.example.hello.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hello.R
import viewModel.Contact

class ContactsAdapter(private val mContacts: List<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val nameTextView: TextView = itemView.findViewById<TextView>(R.id.contact_name)
        val phoneTextView: TextView = itemView.findViewById(R.id.contact_phone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(contactView)

    }

    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
        val contact: Contact = mContacts[position]
        val textView = viewHolder.nameTextView
        val textView1 = viewHolder.phoneTextView
        textView.text = contact.name
        textView1.text = contact.phone
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }
}
