import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Agenda {
    
    private List<Person> people;
    private List<Company> companies;
    // Mapea el id de una person a los ids de las companies
    private Map<Integer, List<Integer>> contacts; 
    
    public Agenda() {
        this.people = new ArrayList<>();
        this.companies = new ArrayList<>();
        this.contacts = new HashMap<>();
    }
    
    // Agregar una person a la agenda
    public void addPerson(Person person) {
        this.people.add(person);
        printAgendaPerson();
    }
    
    // Agregar una company a la agenda
    public void addCompany(Company company) {
        this.companies.add(company);
        printAgendaCompany();
    }
    /* Imprmir Agenda persona */
      public void printAgendaPerson(){
        System.out.println("List people:");
        System.out.println("+----+---------------------+----------------------+--------------------+");
        System.out.println("| ID | Name                |LastName              | Provincie          |");
        System.out.println("+----+---------------------+----------------------+--------------------+");
        for (Person person : people) {
            System.out.printf("| %2d | %-20s| %-20s | %-18s |\n", person.getId(), person.getName(),person.getLastname(), person.getProvince());
        }
        System.out.println("+----+---------------------+----------------------+--------------------+");
     }
     /* Imprmir Agenda persona */
     public void printAgendaCompany(){
        System.out.println("List Companies:");
        System.out.println("+----+---------------------+----------------------+--------------------+");
        System.out.println("| ID | Name                |provincie             | Email              |");
        System.out.println("+----+---------------------+----------------------+--------------------+");
        for (Company company : companies) {
            System.out.printf("| %2d | %-20s| %-20s | %-18s |\n", company.getId(), company.getNameCompany(),company.getProvince(), company.getEmail());
        }
        System.out.println("+----+---------------------+----------------------+--------------------+");
     }
     /* Imprmir Agenda persona */
     public void printAgendaContact(){
        System.out.println("List contacts:");
        System.out.println("+----+---------------------+----------------------+--------------------+");
        System.out.println("| ID | Name                | Company              | Tel.Contact        |");
        System.out.println("+----+---------------------+----------------------+--------------------+");
        for (Person person : people) {
            int personId = person.getId();
            List<Integer> companyIds = contacts.getOrDefault(personId, Collections.emptyList());
            for (int companyId : companyIds) {
                Company company = companies.stream()
                        .filter(c -> c.getId() == companyId)
                        .findFirst()
                        .orElse(null);
                if (company != null) {
                    System.out.printf("| %2d | %-20s| %-20s | %-18s |\n",
                            personId,
                            person.getName() + " " + person.getLastname(),
                            company.getNameCompany(),
                            person.getCell());
                }
            }
        }
        System.out.println("+----+---------------------+----------------------+--------------------+");
         }
    
    // Agregar un contacto entre una person y una company
    public void addContact(int idperson, int idcompany) {
        // Verificar que la person y la company existan
        if (!Validator.existePerson(idperson, people)) {
            throw new RuntimeException("La person con id " + idperson + " no existe.");
        }
        if (!Validator.existeCompany(idcompany, companies)) {
            throw new RuntimeException("La company con id " + idcompany + " no existe.");
        }
        if(!Validator.validatorDiary(contacts, idperson, idcompany)){
            throw new RuntimeException("El contacto entre la person con id " + idperson + " y la company con id " + idcompany + " ya existe.");
        }
        List<Integer> newContact =  new ArrayList<>();
        newContact.add(idcompany);
        this.contacts.put(idperson, newContact);
        printAgendaContact();
    }
    /* TODO: Filtros */
   
    /* buscar persona si encuentra busca si esta asociada a una empresa */
    public  void searchByLastName(String lastname) {
        boolean found = false;     

        for (Person person : people) {
            if (person.getLastname().equalsIgnoreCase(lastname)) {
                found = true;                
                List<Integer> companyIds = contacts.getOrDefault(person.getId(), Collections.emptyList());
                if (!companyIds.isEmpty()) {
                    // La persona tiene contactos asociados, contacto de una empresa
                     
                    for (int companyId : companyIds) {
                        Company company = companies.stream()
                                .filter(c -> c.getId() == companyId)
                                .findFirst()
                                .orElse(null);
                        
                        if (company != null) {
                            System.out.println("Lista de contactos:");
                            System.out.println("+----+---------------------+----------------------+--------------------+");
                            System.out.println("| ID | Nombre              | Company              | Tel.Contact        |");
                            System.out.println("+----+---------------------+----------------------+--------------------+");
                            System.out.printf("| %2d | %-20s| %-20s | %-18s |\n",
                            person.getId(),
                            person.getName() + " " + person.getLastname(),
                            company.getNameCompany(),
                            person.getCell());
                            System.out.println("+----+---------------------+----------------------+--------------------+");
                       
                        }
                    }
                } else {               
                    System.out.println("Persona");
                }
            }
        }
        if (!found) {
            System.out.println("No se encontró ninguna persona con ese nombre.");
        }
    }
    
    // Buscar people por nombre y provincia
    public List<Person> findPeople(String lastname, String province) {
        return this.people.stream()
        .filter(p -> p.getLastname().equalsIgnoreCase(lastname) 
        && p.getProvince().equalsIgnoreCase(province)        
        )
        .collect(Collectors.toList());
    }
    
    // Buscar compañias por provincia
    public List<Company> findCompanies(String province) {
        return this.companies.stream()
        .filter(e -> e.getProvince().equalsIgnoreCase(province))
        .collect(Collectors.toList());
    }
    
    // Buscar people en varias provincees
    public List<Person> searchPeopleByNameAndCity(String name, List<String> provincies) {      
        return this.people.stream()
        .filter(p -> p.getLastname().toLowerCase().equals(name.toLowerCase()) 
                && provincies.stream()
                .anyMatch(pr -> pr.toLowerCase().equals(p.getProvince().toLowerCase())))
        .collect(Collectors.toList());
    }   
}