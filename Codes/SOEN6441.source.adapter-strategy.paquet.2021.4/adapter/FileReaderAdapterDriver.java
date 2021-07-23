/** 
 * Driver program using the FileReaderAdapter Adapter
 */
public class FileReaderAdapterDriver{
  public static void main(String args[]) {

    TextFileReader originalFileType = new TextFileReader();
    Map map; 
    
    // Do an insert using the original FileReader
    map = originalFileType.readFile("filename.txt");

    // Now we'd like to read a JSON file.
    // But this client only understands the readFile()
    // method of TextFileReader, not the readJSONFileType() method.
    // The solution: create an adapter that adapts
    // a JSONFileReader into a TextFileReader!

    TextFileReader wannabeAMap = new FileReaderAdapter(new JSONFileReader());
    map = wannabeAMap.readFile("filename.JSON");}
}
