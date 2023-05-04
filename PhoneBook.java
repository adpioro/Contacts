import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private static final ArrayList<Contact> phoneBook = new ArrayList<>();

    public void printMenu() {
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
    }

    public void addContact() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the type (person, organization): ");
        String contactType = sc.nextLine();
        switch (contactType) {
            case "person":
                phoneBook.add(new Person());
                break;
            case "organization":
                phoneBook.add(new Organization());
                break;
        }

        phoneBook.get(phoneBook.size() - 1).add();
    }

    public void removeContact() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to remove!");
            return;
        }
        listContacts();
        Scanner sc = new Scanner(System.in);
        System.out.print("Select a record: ");
        int contactPos = sc.nextInt() - 1;
        sc.nextLine();
        phoneBook.remove(contactPos);
        System.out.println("The record removed!");
    }

    public void editContact() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }
        listContacts();
        Scanner sc = new Scanner(System.in);
        System.out.print("Select a record: ");
        int contactPos = sc.nextInt() - 1;
        sc.nextLine();
        Contact temp = phoneBook.get(contactPos);
        temp.edit();
    }

    public void countContacts() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }


    public void listContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records in Phone Book!");
            return;
        }
        int bookSize = phoneBook.size();
        for (int i = 1; i <= bookSize; i++) {
            System.out.println(i + ". " + phoneBook.get(i - 1));
        }
    }

    public void infoContact() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records in Phone Book!");
            return;
        }
        listContacts();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to show info: ");
        int contactPos = sc.nextInt() - 1;
        sc.nextLine();
        Contact temp = phoneBook.get(contactPos);
        temp.info();
    }

    public void clear() {
        phoneBook.clear();
    }
}
