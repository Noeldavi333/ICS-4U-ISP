/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsearch;

/**
 *
 * @author David
 */
import java.util.ArrayList;

public class BasicSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String searchParameter = "parameter";
        ArrayList<String> feed = new ArrayList<>();

        String out = "";
        if (searchParameter.equals(" ")) {
            //For the non-filtered we don't even need to search
            for (int i = 0; i < feed.size(); i++) {

                out += "\n" + feed.get(i);
            }
        } else {
            //There shouldn't be too many delays to look through so linear search is good.
            // Also may have multiple relevant pieces of data
            // not entirely sure on how the rss gets in yet but we are required to have an array/list in the program...
            for (int i = 0; i < feed.size(); i++) {
                if (feed.get(i).contains(searchParameter)) {
                    out += "\n" + feed.get(i);
                    //then we just print out into the text field
                }
            }
        }

    }
}
