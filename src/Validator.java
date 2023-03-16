import java.util.List;
import java.util.Map;

public class Validator{
    public static boolean existePerson(int id, List<Person> people) {
        return people.stream()
        .anyMatch(p -> p.getId() == id);
    }
    
    public static boolean existeCompany(int id, List<Company> companies) {
        return companies.stream()
        .anyMatch(c -> c.getId() == id);
    }
    public static boolean validatorDiary(Map<Integer, List<Integer>> contacts,int idP,int idC){
        List<Integer> existingContacts = contacts.get(idP);
        if (existingContacts != null && existingContacts.contains(idC)) {
            return false;
        }
        return true;
    }
}
