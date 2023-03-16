import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public void start(Agenda agenda) {
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPerson(agenda);
                    break;
                case 2:
                    addCompany(agenda);
                    break;
                case 3:
                    addContact(agenda);
                    break;
                case 4:
                    searchPersonByLastName(agenda);
                    break;
                case 5:
                    searchPersonByCity(agenda);
                    break;
                case 6:
                    searchPersonInMultipleCities(agenda);
                    break;
                case 7:
                    searchCompanyByCity(agenda);
                    break;
                case 0:
                    System.out.println("Exiting agenda...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nAgenda Menu");
        System.out.println("1. Add person");
        System.out.println("2. Add company");
        System.out.println("3. Add contact to company");
        System.out.println("4. Search person by last name");
        System.out.println("5. Search person by city *(lastname)");
        System.out.println("6. Search person in multiple cities *(lastname)");
        System.out.println("7. Search company by city");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addPerson(Agenda agenda) {
        Random random = new Random();
        int id = random.nextInt(100);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter lastname: ");
        String lastname = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter cell: ");
        String cell = scanner.nextLine();

        agenda.addPerson(new Person(id, name, lastname, city, email, cell));
        System.out.println("Person added successfully.");

    }

    private void addCompany(Agenda agenda) {
        Random random = new Random();
        int id = random.nextInt(100);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String tel = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        agenda.addCompany(new Company(id, name, city, tel, email));
        System.out.println("Company added successfully.");
    }

    private void addContact(Agenda agenda) {
        System.out.print("Enter person ID: ");
        int personId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter company ID: ");
        int companyId = scanner.nextInt();
        scanner.nextLine();
        try {
            agenda.addContact(personId, companyId);
            System.out.println("Contact added successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add contact: " + e.getMessage());
        }
    }

    private void searchPersonByLastName(Agenda agenda) {
        System.out.print("Enter last name: ");
        String lastname = scanner.next();
        System.out.println("Search results:");
        agenda.searchByLastName(lastname);
    }

    private void searchPersonByCity(Agenda agenda) {
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastname = scanner.next();
        printPeopleList(agenda.findPeople(lastname, city));
        System.out.println("Search results:");
    }

    private void printPeopleList(List<Person> people) {
        if (people.isEmpty()) {
            System.out.println("No se encontraron personas con ese apellido en esa ciudad.");
        } else {
            System.out.println("+----------------------------------------------+");
            System.out.println("|   ID   |   name                |  Province   |");
            System.out.println("+----------------------------------------------+");
            for (Person person : people) {
                System.out.printf("|%7d |%21s |%10s |\n", person.getId(), person.getName() + " " + person.getLastname(),
                        person.getProvince());
            }
            System.out.println("+---------------------------------+");
        }
    }

    /* Sub menu generar la busqueda en varias ciudades */
    public List<String> menuCities(List<String> cities) {
        String city;
        do {
            System.out.println("Enter a city (type 'q' to finish adding cities): ");
            city = scanner.nextLine();
            if (!city.equalsIgnoreCase("q")) {
                cities.add(city);
            }
        } while (!city.equalsIgnoreCase("q"));
        return cities;
    }

    /* Busqueda de persona por apellidos en varias ciudades */
    public void searchPersonInMultipleCities(Agenda agenda) {
        List<String> cities = new ArrayList<>();
        cities = menuCities(cities);
        System.out.println("Enter the person last name: ");
        String name = scanner.next();
        List<Person> results = agenda.searchPeopleByNameAndCity(name, cities);

        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Results:");
            printPeopleList(results);
        }
    }

    /* Busqueda de empresas por ciudades o provincias */
    public void searchCompanyByCity(Agenda agenda) {
        String city;
        System.out.println("Enter the city:");
        city = scanner.nextLine();
        List<Company> results = agenda.findCompanies(city);
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Results:");
            System.out.println("List Companies:");
            System.out.println("+----+---------------------+----------------------+--------------------+");
            System.out.println("| ID | Name                |provincie             | Email              |");
            System.out.println("+----+---------------------+----------------------+--------------------+");
            for (Company c : results) {
                System.out.printf("| %2d | %-20s| %-20s | %-18s |\n", c.getId(), c.getNameCompany(),c.getProvince(), c.getEmail());
            }
            System.out.println("+----+---------------------+----------------------+--------------------+");
            
        }
    }
}
