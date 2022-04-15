package com.lumstep.contacts

interface FragmentNavigator {

    fun fromContactListToContact(contactId: Int)
    fun closeContact()
}