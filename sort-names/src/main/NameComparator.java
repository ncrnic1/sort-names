package main;
import java.util.Comparator;

public class NameComparator implements Comparator<Name> {	
	@Override
	public int compare(Name n1, Name n2) {
		int comp = n1.lastName.compareTo(n2.lastName);
		if (comp != 0) {
			return comp;
		}	
		return n1.firstName.compareTo(n2.firstName);
	}
}
