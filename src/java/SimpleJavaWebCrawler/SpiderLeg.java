package SimpleJavaWebCrawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;



public class SpiderLeg {



    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;




    public boolean crawl(String nextUrl) {

        try {
            Connection connection = Jsoup.connect(nextUrl).userAgent("User-Agent");
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;

            if(connection.response().statusCode() == 200) System.out.println("Received web page at " + nextUrl);

            if(!connection.response().contentType().contains("text/html")) {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }

            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage) {
                this.links.add(link.absUrl("href"));
            }
            return true;

        }
        catch(IOException ioe) {
            System.out.println("Error in out HTTP request" + ioe);
            return false;
        }

    }

    public boolean searchForWord(String word) {

        if(this.htmlDocument == null) {
            System.out.println("ERROR! Call crawl() before performing analysis on the document");
            return false;
        }

        System.out.println("Searching for the word " + word + "...");
        String bodyText = this.htmlDocument.body().text();

        return bodyText.toLowerCase().contains(word.toLowerCase());
    }

    public List<String> getLinks() {
    return this.links;
    }
}
