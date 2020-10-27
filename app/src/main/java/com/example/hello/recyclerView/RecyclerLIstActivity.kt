package com.example.hello.recyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hello.R
import viewModel.Contact

class RecyclerLIstActivity : AppCompatActivity() {
    lateinit var contacts:ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_l_ist)

        val rvContacts = findViewById<View>(R.id.rvContacts) as RecyclerView
        contacts = Contact.createContactsList(15)
        val adapter = ContactsAdapter(contacts)
        rvContacts.adapter = adapter
        rvContacts.layoutManager = LinearLayoutManager(this)
    }
}