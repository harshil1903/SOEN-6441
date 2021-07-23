/**
* The JSONFileReader class.
* This is the Adaptee class.
*/
public class JSONFileReader {
  /**
   * The client does not know this method, though
   * it provides the service that the client wants.  
   */
  public OtherMap readJSONFileType(String msg) {
    System.out.println("JSONFileReader.readOtherFileType(): " + msg);
    OtherMap createdMap = new OtherMap(); 
    // read the file and create the map object
    return createdMap; 
  }
}
