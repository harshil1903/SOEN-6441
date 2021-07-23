/**
 * Immutable generic pair class added with the Comparable interface. Elements of
 * the first type are comparable with themselves. Elements of the second type
 * are comparable with themselves. Elements of type ComparablePair<F,S> are
 * comparable with other elements of type Comparable<F,S>
 */
public class ComparablePair<TypeOfFirst extends Comparable<TypeOfFirst>, TypeOfSecond extends Comparable<TypeOfSecond>>
		implements Comparable<ComparablePair<TypeOfFirst, TypeOfSecond>> {
	private TypeOfFirst first;
	private TypeOfSecond second;

	public ComparablePair() {
	}

	public ComparablePair(TypeOfFirst first, TypeOfSecond second) {
		this.first = first;
		this.second = second;
	}

	public ComparablePair(ComparablePair<TypeOfFirst, TypeOfSecond> newComparablePair) {
		this.first = newComparablePair.getFirst();
		this.second = newComparablePair.getSecond();
	}

	public TypeOfFirst getFirst() {
		return this.first;
	}

	public TypeOfSecond getSecond() {
		return this.second;
	}

	public String toString() {
		return first.getClass().getName() + ":" + first.toString() + " , "
				+ second.getClass().getName() + ":" + second.toString();
	}

	public int compareTo(ComparablePair<TypeOfFirst, TypeOfSecond> otherComparablePair) {
		int compareFirst = first.compareTo(otherComparablePair.getFirst());
		int compareSecond = second.compareTo(otherComparablePair.getSecond());
		if (compareFirst != 0) {
			return compareFirst;
		} else {
			return compareSecond;
		}
	}
}