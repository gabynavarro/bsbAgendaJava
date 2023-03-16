import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Agenda agenda = new Agenda();
        Scanner scanner;

        // agregar algunas person5as y empresas
        agenda.addPerson(new Person(1, "Juan","Perez", "Buenos Aires","j@gmail.com","1154588643"));
        agenda.addPerson(new Person(2, "María", "Gómez", "Córdoba","m@gmail.com", "2613256846"));
        agenda.addPerson(new Person(3, "Pedro", "Martínez", "Buenos Aires","p@gmail.com", "348326586"));
        agenda.addCompany(new Company(1, "Acme Inc.", "Buenos Aires","3232232","acme@gmail.com"));
        agenda.addCompany(new Company(2, "Globex Corp.", "Córdoba","3232232","globex@gmail.com"));
        agenda.addCompany(new Company(3, "Initech S.A.", "Córdoba","3232232","initech@gmail.com"));

        // agregar algunos contactos
        agenda.addContact(1, 1);
        agenda.addContact(2, 2);
        agenda.addContact(3, 1);
        agenda.addContact(3, 3);

         Menu m=new Menu();
         m.start(agenda);

        // Buscar personas y empresas
  //      System.out.println("Persons con nombre 'Juan' y ciudad 'Buenos Aires': " + agenda.findPeople("Juan", "Buenos Aires"));
  //      System.out.println("Companies en ciudad 'Córdoba': " + agenda.findCompanies("Córdoba"));
  //      System.out.println("Persons con nombre 'Juan' en ciudades 'Buenos Aires' y 'Córdoba': " + agenda.findPeopleInProvinces("Juan", List.of("Buenos Aires", "Córdoba")));
    }
    
}
