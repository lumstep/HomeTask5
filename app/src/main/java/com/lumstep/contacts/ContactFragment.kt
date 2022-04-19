package com.lumstep.contacts

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.lumstep.contacts.ContactsListFragment.Companion.contactsList
import kotlin.random.Random

class ContactFragment : Fragment(R.layout.fragment_contact) {

    private var navigator: FragmentNavigator? = null

    private lateinit var photo: ImageView
    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var saveButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photo = view.findViewById(R.id.contact_image)
        editTextName = view.findViewById(R.id.editContactName)
        editTextSurname = view.findViewById(R.id.editContactSurname)
        editTextPhoneNumber = view.findViewById(R.id.editContactPhoneNumber)

        saveButton = view.findViewById(R.id.buttonSaveContact)

        val contactId = requireArguments().getInt(SOME_ID)

        photo.setBackgroundColor(Color.argb(255, Random.nextInt(256),Random.nextInt(256),Random.nextInt(256)))
        editTextName.setText(contactsList[contactId].name)
        editTextSurname.setText(contactsList[contactId].surname)
        editTextPhoneNumber.setText(contactsList[contactId].phoneNumber.toString())

        saveButton.setOnClickListener {
            contactsList[contactId].name = editTextName.text.toString()
            contactsList[contactId].surname = editTextSurname.text.toString()
            contactsList[contactId].phoneNumber = editTextPhoneNumber.text.toString().toLong()

            navigator?.closeContact()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentNavigator) navigator = context
    }

    companion object {
        const val FRAGMENT_CONTACT_TAG = "FRAGMENT_CONTACT_TAG"

        private const val SOME_ID = "id"

        fun newInstance(contactId: Int) = ContactFragment().also {
            it.arguments = Bundle().apply {
                putInt(SOME_ID, contactId)
            }
        }
    }
}