
package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


// So apparently you can't connect to the internet from the main thread/ main class
public class HandleXML extends Activity {

    public TextView alsoListOfRecentObjects;

    String route, status, school;

    public String output = "No notifications";
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;
    boolean relevant = false;
    String name = "", date = "", title = "", description = "";
    Boolean parseComplete = false;

    // so the main can get the result


    public void fetchXML(final String searchParameter) {



        //getting a new thread to connect to the internet

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                alsoListOfRecentObjects = (TextView) MainActivity.activity.findViewById(R.id.notification_view);

                System.out.println("1");

                try {
                    //setting up the url and the connection specs
                    URL url = new URL("https://portal.nsts.ca/rss/feed-en-CA.xml");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    System.out.println("2");

                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);

                    System.out.println("3");

                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();

                    System.out.println("4");

                    //calling the function that will parse the document

                   System.out.println("XML Fetching Complete :)");

                    System.out.println("what the actual fuck");
                    //create an output string

                    alsoListOfRecentObjects.setText("");


                    // Create a builder factory
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                    // Configure it to coalesce CDATA nodes
                    factory.setCoalescing(true);
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    // doc will not contain any CDATA nodes

                    Document doc = builder.parse(stream);

                    doc.getDocumentElement().normalize();//idk what this is tbh

                    NodeList itemList = doc.getElementsByTagName("item"); //getting a list of all the item elements

                    for (int i = 0; i < itemList.getLength(); i++) {

                        //get the next item
                        Node currentNode = itemList.item(i);

                        //reset the strings
                        title = "";
                        date = "";
                        description = "";

                        if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element currentElement = (Element) currentNode;

                            NodeList textList = currentElement.getElementsByTagName("title");   //I have to get
                            // multiple nodes because every line feed creates a new node. this may end up giving
                            // us a few unwanted new lines


                            for (int j = 0; j < textList.getLength(); j++) {
                                //reading in the contents of the title tag
                                title += textList.item(j).getTextContent();
                            }

                            textList = currentElement.getElementsByTagName("description");

                            for (int j = 0; j < textList.getLength(); j++) {
                                //reading in the contents of the description tag
                                description += textList.item(j).getTextContent();
                            }

                            textList = currentElement.getElementsByTagName("pubDate");
                            for (int j = 0; j < textList.getLength(); j++) {
                                //reading in the date tag
                                date += textList.item(j).getTextContent();
                            }


                            //checking to see if this item contains the search parameter
                            if (title.contains(searchParameter)) {
                                relevant = true;
                            } else if (description.contains(searchParameter)) {
                                relevant = true;
                            }


                            //and now setting up the final output string
                            if ((relevant) && (title.contains("Route"))) {


                                alsoListOfRecentObjects.append(title);
                                alsoListOfRecentObjects.append("\n" + date);
                                alsoListOfRecentObjects.append("\n" + description);
                                alsoListOfRecentObjects.append("\n");
                                alsoListOfRecentObjects.append("\n");


                                //and reset the boolean
                                relevant = false;

                            }
                        }
                    }

                    System.out.println("UGHHHHHHHHHH");
                    //closing the input stream

                    System.out.println("5");
                    stream.close();

                    conn.disconnect();

                    parseComplete = true;

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        //running the created thread


        thread.start();
    } //done


    //public void parseXMLAndStoreIt(InputStream is, String searchParameter) throws IOException,
      //      SAXException, ParserConfigurationException {


    //}

    public void setOutput(String ass) {

        output = ass;
    }


}
