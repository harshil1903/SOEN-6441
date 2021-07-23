import java.util.LinkedList;

public class DoubleToStringReaderAdapter extends StringReader {

    public DoubleReader d_doubleReader;

    public DoubleToStringReaderAdapter()
    {
        d_doubleReader = new DoubleReader();
    }

    public LinkedList<String> read_kbd()
    {
        return  translate(d_doubleReader.read_double());
    }

    public LinkedList<String> translate(LinkedList<Double> p_myDoubles)
    {
        LinkedList<String> l_myStrings = new LinkedList<>();
        for(Double l_double : p_myDoubles)
        {
            l_myStrings.add(l_double.toString() + " ");
        }
        return l_myStrings;
    }

}
