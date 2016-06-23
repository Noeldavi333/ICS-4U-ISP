package com.example.gmoro.finalapplication;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


// So apparently you can't connect to the internet from the main thread/ main class
public class HandleXML {

    private String output = "No notifications";
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;
    boolean relevant = false;
    String name = "", date = "", title = "", description = "";

    // so the main can get the result
    public String getOutput(){
        return output;
    }

    public void parseXMLAndStoreIt(XmlPullParser parser, String searchParameter) {
        int event;


        try {
            //What type of event has the parser reached? Different events run different code in the switch case.
            event = parser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_TAG:
                        //at the opening tag
                        //get the tag's name
                        name = parser.getName();

                        output = "Error ln 118";
                        break;


                    case XmlPullParser.TEXT:


                        if (name.equals("pubDate")) {
                            //this tag has the date
                            date = parser.getText();
                            output = "Error ln 128";
                        }


                        break;
                    case XmlPullParser.COMMENT:
                        if (name.equals("title")) {
                            //this tag contains the route number

                            //reading in the value

                            title = parser.getText();

                            output = "Error ln 141";

                            //If the specified route number is in here, we'll want to keep this item
                            if (title.contains(searchParameter)) {
                                relevant = true;
                            }
                        } else if (name.equals("description")) {
                            //this tag has the school
                            description = parser.getText();

                            //we'll want to print this if it has the correct school
                            if (description.contains(searchParameter)) {
                                relevant = true;
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        //get the tag's name again. We may go directly from one end tag to another
                        name = parser.getName();
                        output = "Error ln 161";
                        // after reading all the contents of the "item" parent element
                        if ((name.equals("item")) && (title.contains("Route"))) { //checking to see that it's not a "no closures" or "no general notifications
                            if (relevant == true) {
                                //printing out relevant info... we'll have
                                //to cut up the strings a bit
                                //because they look yucky as-is

                                //Separating the route data and the bus status
                                String route = title.substring(title.indexOf("Route"), title.indexOf("Status"));
                                String status = title.substring(title.indexOf("Status"), title.indexOf("]"));

                                output = "Error ln 173";

                                //Separating the affected school out of the description
                                String school = description.substring(description.indexOf("Schools"), description.indexOf("</p>]]"));

                                // print out route, status, school, date to the text field

                                //add details
                                output += title;
                                output += "\n" + date;
                                output += "\n" + description;
                                output +="\n";
                                output +="\n";

                                //and reset the boolean
                                relevant = false;
                            }
                        }
                        break;
                }
                //go to the next tag
                event = parser.next();
            }
            //let the main class know when the parsing is done
            parsingComplete = false;
        }

        catch (Exception e) {
        // Java likes to make sure we have all the possible errors covered in a try catch
        }
    }

    public void fetchXML(final String searchParameter){
        //getting a new thread to connect to the internet
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {

                try {
                    //setting up the url and the connection specs
                    URL url = new URL("https://portal.nsts.ca/rss/feed-en-CA.xml");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);

                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();
                    // creating the parser
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser parser = xmlFactoryObject.newPullParser();
                    //setting up the parser
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(stream, null);

                    //calling the function that will parse the document
                    parseXMLAndStoreIt(parser, searchParameter);
                    //closing the input stream
                    stream.close();
                }

                catch (Exception e) {
                    //yet another forced catch
                }
            }
        });

        //running the created thread
        thread.start();
    }
}
