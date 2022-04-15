package com.lumstep.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            val fragment = ContactsListFragment.newInstance()

            replace(R.id.frame_layout, fragment, ContactsListFragment.FRAGMENT_CONTACTS_LIST_TAG)
            addToBackStack(ContactsListFragment.FRAGMENT_CONTACTS_LIST_TAG)

            commit()
        }
    }

    override fun fromContactListToContact(contactId: Int) {
        supportFragmentManager.beginTransaction().run {
            val fragment = ContactFragment.newInstance(contactId)

            replace(R.id.frame_layout, fragment, ContactFragment.FRAGMENT_CONTACT_TAG)

            addToBackStack(ContactFragment.FRAGMENT_CONTACT_TAG)
            commit()
        }
    }

    override fun closeContact() {
        supportFragmentManager.popBackStack()
    }
}