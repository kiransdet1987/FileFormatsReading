package file.format.reading.Json;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReadingOne {

	public static void main(String[] args) throws StreamReadException, DatabindException, FileNotFoundException, IOException {
		// 1. Create ObjectMapper
	    ObjectMapper mapper = new ObjectMapper();

	    // 2. Read JSON file
	    Person person = mapper.readValue(new FileReader("testData.json"), Person.class);

	    // 3. Access data using Person class
	    System.out.println("Name: " + person.getName());
	    System.out.println("Age: " + person.getAge());
	    System.out.println("City: " + person.getCity());
	    System.out.println("Title: " + person.getTitle());
	    System.out.println("Occupation: " + person.getOccupation().getTitle() + " at " + person.getOccupation().getCompany());
	  }
	}

/*
 * testData.json
{
	  "name": "Alice",
	  "age": 30,
	  "city": "New York",
	  "title":"Hi",
	  "occupation": {
	    "title": "Software Engineer",
	    "company": "Awesome Inc."
	  }
	}
	
*/
