import java.util.LinkedList;

public class DoubleToStringReaderAdapter extends StringReader {

    public DoubleReader Reader;

    public DoubleToStringReaderAdapter()
    {
        Reader = new DoubleReader();
    }

    public LinkedList<String> read_kbd()
    {
        LinkedList<Double> numbers = Reader.read_double();
        LinkedList<String> strings = new LinkedList<>();
        System.out.println("Inside translate");
        for(Double d : numbers)
        {
            strings.add(d.toString());
        }

        return strings;
    }


}
