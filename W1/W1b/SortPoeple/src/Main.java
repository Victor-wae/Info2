import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{

        public static void main(String[] args) {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person("Guillaume",20));
            persons.add(new Person("John",50));
            persons.add(new Person("Guillaume",10));
            persons.add(new Person("John",10));
            persons.add(new Person("Luc",5));

            sortPerson(persons);
            System.out.println(persons);

        }

    private static void sortPerson(ArrayList<Person> persons) {
            Collections.sort(persons, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    int compare = o1.name.compareTo(o2.name);
                    if (compare == 0)return o1.age >= o2.age ? 1:-1;
                    return compare;
                }
            });
    }
}