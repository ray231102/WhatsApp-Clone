package com.idn.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.whatsappclone.R
import com.idn.whatsappclone.listeners.ContactsClickListener
import com.idn.whatsappclone.utills.Contact
import kotlinx.android.extensions.LayoutContainer
import java.util.ArrayList
import kotlinx.android.synthetic.main.item_contacts.view.*


class ContactAdapter(val contacts: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactsViewHolder>() {

    private var clickListener: ContactsClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactsViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_contacts,
            parent, false
        )
    )

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bindItem(contacts[position], clickListener)
    }

    class ContactsViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun bindItem(contact: Contact, listener: ContactsClickListener?) {
            containerView?.txt_contact_name!!.text = contact.name
            containerView.txt_contact_number.text = contact.phone
            itemView.setOnClickListener {
                listener?.onContactClicked(contact.name, contact.phone) }
        }
    }

    fun setOnItemClickListener(listener: ContactsClickListener) { clickListener = listener
        notifyDataSetChanged()
    }
}