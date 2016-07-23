import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
public class SyntacticallyCorrect {

    public static void main(String[] args) {

        Model myRawModel = null; // define outside try-catch
        String urlString =
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3test/wilson.n3";
        boolean isBadParse = false;  //. assume it's ok, prove otherwise
        try {
            // Here we load from a public URL
            myRawModel =
                    FileManager.get().loadModel(urlString, "N3");
        } catch (Exception e) {
            System.out.println("EXCEPTION in parsing the N3.\n" +
                    e.getMessage() +
                    "\n at URL: " + urlString);
            isBadParse = true;
        }
        if (isBadParse) {
            System.out.println("Terminating program");
            return;
        }
        // write the model to System.out (or any output stream)
        // if no 2nd parameter, the output is RDF/XML
        myRawModel.write(System.out, "N3");
        // it's sometimews helpful to add a final print line just to see that
        // our processing has completed
        System.out.println("< -- Jena Done -->");
    }
}
