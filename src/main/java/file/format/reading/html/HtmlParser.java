package file.format.reading.html;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
	
	public static void main(String[] args) throws IOException {
        
        // Specify the path to the HTML file
        File inputFile = new File("testData.html");

        // Parse the HTML file
        Document doc = Jsoup.parse(inputFile, "UTF-8");
        // Parse the HTML string
        //Document doc = Jsoup.parse(html);

        System.out.println("********** 1st logic*************************");
        // Select all rows after the header row
        Elements rows = doc.select("table.editorDemoTable tbody tr:gt(0)");

        // Iterate over rows and print the first column (Name)
        for (Element row : rows) {
            // Get the first <td> in the row, which contains the name
            Element nameCell = row.select("td").first();
            if (nameCell != null) {
                System.out.println("Name: " + nameCell.text());
            }
        }
        
        System.out.println("********** 2nd logic*************************");
        
     // Select the first data row after the header (which is the second <tr>)
        Element firstDataRow = doc.select("table.editorDemoTable tbody tr").get(1); // Index 1, because index 0 is the header row

        // Get all <td> elements from the first data row
        Elements cells = firstDataRow.select("td");

        // Extract name, city, and age from the first row
        String name = cells.get(0).text();
        String city = cells.get(1).text();
        String age = cells.get(2).text();

        // Print the extracted information
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Age: " + age);
    }

}


/*
// HTML content as a string
String html = "<table class=\"editorDemoTable\">" +
        "<tbody>" +
        "<tr>" +
        "<td><strong>Name</strong></td>" +
        "<td><strong>City</strong></td>" +
        "<td><strong>Age</strong></td>" +
        "</tr>" +
        "<tr>" +
        "<td>John</td>" +
        "<td>Chicago</td>" +
        "<td>23</td>" +
        "</tr>" +
        "<tr>" +
        "<td>Lucy</td>" +
        "<td>Wisconsin</td>" +
        "<td>19</td>" +
        "</tr>" +
        "</tbody>" +
        "</table>";


*/