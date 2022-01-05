import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParsBookm {

    public static void main(String[] args) throws IOException {

        String url = "https://www.marathonbet.ru";
        System.out.println("Loading page now ----------------------------------" + url);

        // HtmlUnit
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(3000);
        HtmlPage htmlPage = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(5000);

        String pageAsXml = htmlPage.asXml();

        // Jsoup parsing
        Document doc = Jsoup.parse(pageAsXml);
        Element divElement = doc.getElementById("div");
        System.out.println(divElement);
//        for (Element divEl: divElement) {
//            System.out.println(divEl);
//
//        }


    }
}
