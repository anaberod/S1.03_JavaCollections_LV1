package EX1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ArrayList<Month> months = new ArrayList<>();

        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

        months.add(7, new Month("August"));

        System.out.println("\nArrayList with all the months in order: ");
        for (Month m : months) {
            System.out.println(m);
        }

        Set<Month> monthSet = new HashSet<>(months);
        monthSet.add(new Month("December"));
        monthSet.add(new Month("February"));
        System.out.println("\nHashSet without duplicates: ");
        for (Month m : monthSet) {
            System.out.println(m);
        }

        System.out.println("\nTraversal with for loop (index):");
        for (int i = 0; i < months.size(); i++) {
            System.out.println(months.get(i));

        }
        System.out.println("\nIterating through HashSet with Iterator:");
        Iterator<Month> monthIterator = monthSet.iterator();
        while (monthIterator.hasNext()) {
            System.out.println(monthIterator.next());
        }


    }
}
