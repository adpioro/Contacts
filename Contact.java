import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Contact {

    private String  timeCreated;
    private String  lastEdited;

    public void setTimeCreated() {
        timeCreated = LocalDateTime.now().toString();
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setLastEdited() {
        this.lastEdited = LocalDateTime.now().toString();
    }

    public String getLastEdited() {
        return lastEdited;
    }
    abstract void edit();

    abstract void add();

    abstract void info();

    /*
    1. The phone number should be split into groups using a space or dash. One group is also possible.
    2. Before the first group, there may or may not be a plus symbol.
    3. The first group or the second group can be wrapped in parentheses, but there should be no more than one group that is wrapped in parentheses. There may also be no groups wrapped in parentheses.
    4. A group can contain numbers, uppercase, and lowercase English letters. A group should be at least 2 symbols in length. But the first group may be only one symbol in length.

     */
    boolean isNumberValid(String number) {
        boolean isNumberValid;
        Pattern pattern = Pattern.compile("\\+?[\\s-]?((\\(\\w+\\)[\\s-]\\w{2,})|(\\w+[\\s-]\\(\\w{2,}\\))|(\\(?\\w+\\)?))([\\s-]\\w{2,})*");
        Matcher matcher = pattern.matcher(number);

        isNumberValid = matcher.matches();

        if (!isNumberValid) {
            System.out.println("Wrong number!");
        }
        return isNumberValid;
    }
}

class Person extends Contact {

    private String name;
    private String surname;
    private String birthDate;
    private String gender;
    private String number;

    Scanner sc = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.print("Enter the name: ");
        this.name = sc.nextLine();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname() {
        System.out.print("Enter the surname: ");
        this.surname = sc.nextLine();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate() {
        System.out.print("Enter the birth date: ");
        String tempBirthDate = sc.nextLine();
        if (!tempBirthDate.isEmpty()) {
            birthDate = tempBirthDate;
        } else {
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender() {
        System.out.print("Enter the gender (M, F): ");
        String tempGender = sc.nextLine();
        if (tempGender.matches("[MF]")) {
            gender = tempGender;
        } else {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber() {
        System.out.print("Enter the number: ");
        String tempNum = sc.nextLine();
        if (!isNumberValid(tempNum)) {
            this.number = "[no number]";
        } else {
            this.number = tempNum;
        }
    }

    @Override
    void edit() {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String fieldToEdit = sc.nextLine();
        switch (fieldToEdit) {
            case "name":
                setName();
                break;
            case "surname":
                setSurname();
                break;
            case "birth":
                setBirthDate();
                break;
            case "gender":
                setGender();
                break;
            case "number":
                setNumber();
                break;
            default:
                System.out.println("Wrong field!");
        }
        setLastEdited();
        System.out.println("The record updated!\n");
    }

    @Override
    void add() {
        setName();
        setSurname();
        setBirthDate();
        setGender();
        setNumber();
        setTimeCreated();
        setLastEdited();
        System.out.println("The record added!\n");
    }

    @Override
    void info() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Birth date: " + getBirthDate());
        System.out.println("Gender: " + getGender());
        System.out.println("Number: " + getNumber());
        System.out.println("Time created: " + getTimeCreated());
        System.out.println("Time last edit: " + getLastEdited() + "\n");
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}

class Organization extends Contact {

    private String name;
    private String address;
    private String number;

    Scanner sc = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.print("Enter the name: ");
        name = sc.nextLine();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        System.out.print("Enter the address: ");
        address = sc.nextLine();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber() {
        System.out.print("Enter the number: ");
        String tempNum = sc.nextLine();
        if (!isNumberValid(tempNum)) {
            number = "[no number]";
        } else {
            number = tempNum;
        }
    }



    @Override
    void edit() {
        System.out.print("Select a field (name, address, number): ");
        String fieldToEdit = sc.nextLine();
        switch (fieldToEdit) {
            case "name":
                setName();
                break;
            case "address":
                setAddress();
                break;
            case "number":
                setNumber();
                break;
            default:
                System.out.println("No such field.");
        }
        setLastEdited();
        System.out.println("The record updated!\n");
    }

    @Override
    void add() {
        setName();
        setAddress();
        setNumber();
        setTimeCreated();
        setLastEdited();
        System.out.println("The record added!\n");
    }

    @Override
    void info() {
        System.out.println("Organization name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Number: " + getNumber());
        System.out.println("Time created: " + getTimeCreated());
        System.out.println("Time last edit: " + getLastEdited() + "\n");
    }

    @Override
    public String toString() {
        return getName();
    }
}