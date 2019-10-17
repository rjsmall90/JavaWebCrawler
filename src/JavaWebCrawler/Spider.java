package JavaWebCrawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider {

    private static int count; //counts the amount of times keyword appears
    private static final int MAX_PAGES_TO_SEARCH = 10; //limits number of searched pages
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();


    public void search(String url, String searchWord) {

        while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
            String currentUrl;
            SpiderLeg leg = new SpiderLeg();
            if (this.pagesToVisit.isEmpty()) {
                currentUrl = url;
                this.pagesVisited.add(url);
            } else {
                currentUrl = this.nextUrl();
                count++;
            }

            leg.crawl(currentUrl); //references the crawl method in SpiderLeg.class

            boolean success = leg.searchForWord(searchWord);
            if(success) {
                System.out.println(String.format("**Success** Word %s found at %s. Count: %s", searchWord, currentUrl, count));
                break;
            }
            this.pagesToVisit.addAll(leg.getLinks());
        }
        System.out.println(String.format("**Done** Visited %s web pages(s)", this.pagesVisited.size()));
    }


    private String nextUrl() {
        String nextUrl;
        do {
            nextUrl = this.pagesToVisit.remove(0);
        }
        while (this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);

        return nextUrl;
    }

}