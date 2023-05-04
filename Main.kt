package contacts

import PhoneBook
import kotlin.system.exitProcess

/*
PhoneBook contains contacts of persons and organizations – both extends single Contact class.
 */

fun main() {
    val phoneBook = PhoneBook()
    do {
        phoneBook.printMenu()
        val response = readln()
        when (response) {
            "add" -> phoneBook.addContact()
            "remove" -> phoneBook.removeContact()
            "edit" -> phoneBook.editContact()
            "count" -> phoneBook.countContacts()
            "info" -> phoneBook.infoContact()
        }
    } while (response != "exit")
    phoneBook.clear()
    exitProcess(0)
}