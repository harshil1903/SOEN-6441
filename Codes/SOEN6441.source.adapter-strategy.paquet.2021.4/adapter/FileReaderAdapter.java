/**
 * The FileReaderAdapter class. This is the Adapter class. It adapts a
 * OtherFileReadet to a FileReader. Its method signature is that of a
 * FileReader.
 */
public class FileReaderAdapter extends TextFileReader {
	/**
	 * The adapter contains the FileReader Adaptee
	 */
	private JSONFileReader otherFileType;

	/**
	 * Upon creation, the Adapter is plugged into the JSONFileReader Adaptee
	 */
	public FileReaderAdapter(JSONFileReader p_fr) {
		// the roundPeg is plugged into the adapter
		this.otherFileType = p_fr;
	}

	/**
	 * The Adapter provides the Target's method and translates it to the
	 * corresponding Adaptee's method call. If the return types are different, a
	 * tranlsation is applied on the return value.
	 * 
	 * @param str: message to be printed (for demonstration purpose)
	 * @return the Map object corresponding to the OtherMap object read from the
	 *         JSON file
	 */
	public Map readFile(String str) {
		// the roundPeg can now be inserted in the same manner as a squarePeg!
		return (translate(otherFileType.readJSONFileType(str)));
	}

	/**
	 * In case where the return type of the methods of the Target and the Adaptee are not the same, 
	 * A translation may need to be applied. 
	 * 
	 * @param p_om: the OtherMap object to be translated into a Map object
	 * @return the Map object that corresponds to the OtherMap object
	 */
	private Map translate(OtherMap p_om) {
		Map translatedMap = new Map();
		// translate the OtherMap object into a Map object
		return translatedMap;
	}
}
