package com.lumstep.contacts

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class ContactsListFragment : Fragment(R.layout.fragment_contacts_list) {

    private var navigator: FragmentNavigator? = null

    private lateinit var cardView1: CardView
    private lateinit var cardView2: CardView
    private lateinit var cardView3: CardView
    private lateinit var cardView4: CardView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardView1 = view.findViewById(R.id.contact_1)
        cardView2 = view.findViewById(R.id.contact_2)
        cardView3 = view.findViewById(R.id.contact_3)
        cardView4 = view.findViewById(R.id.contact_4)

        fillCardViews(view)

        cardView1.setOnClickListener {
            navigator?.fromContactListToContact(0)
        }
        cardView2.setOnClickListener {
            navigator?.fromContactListToContact(1)
        }
        cardView3.setOnClickListener {
            navigator?.fromContactListToContact(2)
        }
        cardView4.setOnClickListener {
            navigator?.fromContactListToContact(3)
        }

    }

    private fun fillCardViews(view: View) {
        view.findViewById<TextView>(R.id.contact_1_name).text = contactsList[0].name
        view.findViewById<TextView>(R.id.contact_1_surname).text = contactsList[0].surname
        view.findViewById<TextView>(R.id.contact_1_phone).text =
            contactsList[0].phoneNumber.toString()

        view.findViewById<TextView>(R.id.contact_2_name).text = contactsList[1].name
        view.findViewById<TextView>(R.id.contact_2_surname).text = contactsList[1].surname
        view.findViewById<TextView>(R.id.contact_2_phone).text =
            contactsList[1].phoneNumber.toString()

        view.findViewById<TextView>(R.id.contact_3_name).text = contactsList[2].name
        view.findViewById<TextView>(R.id.contact_3_surname).text = contactsList[2].surname
        view.findViewById<TextView>(R.id.contact_3_phone).text =
            contactsList[2].phoneNumber.toString()

        view.findViewById<TextView>(R.id.contact_4_name).text = contactsList[3].name
        view.findViewById<TextView>(R.id.contact_4_surname).text = contactsList[3].surname
        view.findViewById<TextView>(R.id.contact_4_phone).text =
            contactsList[3].phoneNumber.toString()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentNavigator) navigator = context
    }

    companion object {
        const val FRAGMENT_CONTACTS_LIST_TAG = "FRAGMENT_CONTACTS_LIST_TAG"
        fun newInstance() = ContactsListFragment()

        var contactsList: ArrayList<Contact> =
            arrayListOf(
                Contact("Vasya", "Pupkin", 375295621365),
                Contact("Serega", "Ment", 375442653418),
                Contact("Kirill", "Siplyi", 375178462354),
                Contact("Dimon", "Ne_brat'_trubku", 375441236543)
            )
    }
}