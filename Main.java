import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonManager personManager = new PersonManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("CRUD Operations:");
            System.out.println("1. Create");
            System.out.println("2. Read All");
            System.out.println("3. Read by ID");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    Person newPerson = new Person(name, age);
                    personManager.create(newPerson);
                    System.out.println("Person created with ID: " + newPerson.getId());
                    break;
                case 2:
                    List<Person> allPeople = personManager.readAll();
                    for (Person person : allPeople) {
                        System.out.println("ID: " + person.getId() + ", Name: " + person.getName() + ", Age: " + person.getAge());
                    }
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int readId = scanner.nextInt();
                    Person foundPerson = personManager.readById(readId);
                    if (foundPerson != null) {
                        System.out.println("ID: " + foundPerson.getId() + ", Name: " + foundPerson.getName() + ", Age: " + foundPerson.getAge());
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Person updatedPerson = personManager.readById(updateId);
                    if (updatedPerson != null) {
                        System.out.print("Enter new name: ");
                        updatedPerson.setName(scanner.nextLine());
                        System.out.print("Enter new age: ");
                        updatedPerson.setAge(scanner.nextInt());
                        personManager.update(updatedPerson);
                        System.out.println("Person updated.");
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    personManager.delete(deleteId);
                    System.out.println("Person deleted.");
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}