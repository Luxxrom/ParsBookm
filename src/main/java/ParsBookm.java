import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsBookm {

    public static void main(String[] args) throws IOException {

//        String url = "https://www.marathonbet.ru";
//        System.out.println("Loading page now ----------------------------------" + url);
//
//        // HtmlUnit
//        WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        webClient.getOptions().setTimeout(5000);
//        HtmlPage htmlPage = webClient.getPage(url);
//        webClient.waitForBackgroundJavaScript(10000);
//
//        String pageAsXml = htmlPage.asXml();
//
//        // Jsoup parsing
//        Document page = Jsoup.parse(pageAsXml);
//        Elements divElement = page.select("div[class=content]");
////        System.out.println(divElement.text());
//        for (Element divEl : divElement) {
//            String[] elPoints = divEl.text().split("\\.");
//            for (String elPoint : elPoints) {
//                System.out.println(elPoint);
//            }
//        }


        String url = "https://sbermegamarket.ru/";
        System.out.println("Loading page now ----------------------------------" + url);

        // HtmlUnit
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(5000);
        HtmlPage htmlPage = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(10000);

        String pageAsXml = htmlPage.asXml();

        // Jsoup parsing
        Document page = Jsoup.parse(pageAsXml);
//        Elements divElement = page.select("div[class=content]");
        Elements divElements = page.select("div[class=catalog-listing__items]");
//        System.out.println(divElement.text());
        for (Element divEl : divElements) {
//            String[] elPoints = divEl.text().split("\\.");
//            for (String elPoint : elPoints) {
//                System.out.println(elPoint);
            Elements divElements1 = page.select("div[class=item-title]");
            for (Element divEl1 : divElements1) {

                Elements divElements2 = page.select("a");
                for (Element divEl2 : divElements2) {

                    System.out.println(divEl2.text());
//                    System.out.println(divEl1.text());

//                System.out.println(divEl.text());
                }
            }
        }

    }
}
