import java.util.ArrayList;
import java.util.List;

class PersonManager {
    private List<Person> people = new ArrayList<>();

    public void create(Person person) {
        people.add(person);
    }

    public List<Person> readAll() {
        return new ArrayList<>(people);
    }

    public Person readById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void update(Person updatedPerson) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == updatedPerson.getId()) {
                people.set(i, updatedPerson);
                return;
            }
        }
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}