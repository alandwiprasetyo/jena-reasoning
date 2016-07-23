/**
 * Created by macair on 7/23/16.
 */
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.*;
public class Select {
    public static void main(String[] args) {
        // LOAD Raw Model from URL
        Model myRawModel =
                FileManager.get().loadModel(
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/Houghland.n3", "N3");

         // READ another N3 into the Model
         FileManager.get().readModel(myRawModel, "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/cruz.n3", "N3");

         // READ another N3 into the Model
         FileManager.get().readModel(myRawModel,
                 "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/abraham.n3", "N3");

         // READ another N3 into the Model
         FileManager.get().readModel(myRawModel,
                 "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/akundi.v2.n3", "N3");

         // READ another N3 into the Model
         FileManager.get().readModel(myRawModel,
                 "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/bennett.n3", "N3");

        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/hanna.n3", "N3");
        // READ another N3 into the Model
        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/liew_hw2.n3", "N3");
        // READ another N3 into the Model
        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/ramani.n3", "N3");
        // READ another N3 into the Model
        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/rawal.n3", "N3");
        // READ another N3 into the Model
        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/sison.n3", "N3");
        // READ another N3 into the Model
        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/tara.n3", "N3");
// READ another N3 into the Model
        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/turney.n3", "N3");
// READ another N3 into the Model
        FileManager.get().readModel(myRawModel,
                "http://lyle.smu.edu/~coyle/cse7392.semweb/onto/a3/wilson.n3", "N3");
        // Create an RDFS inference model from the Raw Model
        InfModel infmodel = ModelFactory.createRDFSModel(myRawModel);
        // Create a new SPARQL query
        String queryString =
                "PREFIX drc: <http://www.codesupreme.com/onto/cse7392/#> " +
                        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
                        "SELECT DISTINCT ?lname ?fname ";
// create a Jena query from the queryString
        Query query = QueryFactory.create(queryString);
// create a Jena QueryExecution object that knows the query
// and the N3 over which the query will be run
        QueryExecution qe = QueryExecutionFactory.create(query, infmodel);
// execute the query - get back a ResultSet
        ResultSet results = (ResultSet) qe.execSelect();
// iterate over the result set
        while(results.hasNext()) {
            QuerySolution sol = results.next();
            System.out.println("Solution:" + sol.toString() );
        }
         // READ another N3 into the Model
    }
}
