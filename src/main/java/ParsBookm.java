import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

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
//        webClient.getOptions().setUseInsecureSSL(true);
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


//        String url = "https://sbermegamarket.ru/";
//        String url = "https://sbermegamarket.ru/catalog/kofe-v-zernah/";
//        System.out.println("Loading page now ----------------------------------" + url);
//
//        // HtmlUnit
//        WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        webClient.getOptions().setTimeout(5000);
//        webClient.getOptions().setUseInsecureSSL(true);
//        HtmlPage htmlPage = webClient.getPage(url);
//        webClient.waitForBackgroundJavaScript(10000);
//
//        String pageAsXml = htmlPage.asXml();
//
//        // Jsoup parsing
//        Document page = Jsoup.parse(pageAsXml);
//        Element mainEl = page.selectFirst("main");
////        Elements divElements = mainEl.select("div[class=catalog-listing__items]");
//        Elements divElements = mainEl.select("div");
//        for (Element divEl : divElements) {
////            System.out.println(divEl);
//
//            Elements divElements1 = divEl.select("div[class=catalog-listing__items]");
//            for (Element divEl1 : divElements1) {
////                System.out.println(divEl1);
////                if (true) break;
//
////                Elements divElements2 = divEl1.select("div.item-info[div.item-money.span, div.item-title mobile-only.a]");
//                Elements divElements2 = divEl1.select("div[class=item-info] span");
//
////                Elements divElements2 = divEl1.select("a[class=ddl_product_link]");
//                int i = 0;
//                for (Element divEl2 : divElements2) {
////                    System.out.println(divEl2.text());
////                    if (true) break;
//                    System.out.println( String.valueOf(i++) + " " + divEl2.text());
////                    System.out.println(divEl1.text());
//
////                System.out.println(divEl.text());
//                }
//            }
//        }

        String url = "https://sbermegamarket.ru/catalog/kofe-v-zernah/";
        System.out.println("Loading page now ----------------------------------" + url);

        // HtmlUnit
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(5000);
        webClient.getOptions().setUseInsecureSSL(true);
        HtmlPage htmlPage = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(10000);

        String pageAsXml = htmlPage.asXml();

        // Jsoup parsing
        Document page = Jsoup.parse(pageAsXml);
        Element mainEl = page.selectFirst("main");

        Elements elementsDiv = listDiv(mainEl);
//        Elements divElements = mainEl.select("div[class=catalog-listing__items]");
//        Elements divElements = mainEl.select("div");
//        for (Element divEl : divElements) {
////            System.out.println(divEl);


//            Elements divElements1 = divEl.select("div[class=catalog-listing__items]");
//            for (Element divEl1 : divElements1) {
////                System.out.println(divEl1);
////                if (true) break;
//
////                Elements divElements2 = divEl1.select("div.item-info[div.item-money.span, div.item-title mobile-only.a]");
//                Elements divElements2 = divEl1.select("div[class=item-info] span");
//
////                Elements divElements2 = divEl1.select("a[class=ddl_product_link]");
//                int i = 0;
//                for (Element divEl2 : divElements2) {
////                    System.out.println(divEl2.text());
////                    if (true) break;
//                    System.out.println( String.valueOf(i++) + " " + divEl2.text());
////                    System.out.println(divEl1.text());
//
////                System.out.println(divEl.text());
//                }
//            }
    }

    static Elements listDiv(Element node) {

        Attributes attributeEl = node.attributes();
        for (Attribute attEl : attributeEl) {
            System.out.print(attEl);
        }
        System.out.println("  " + node.text().toUpperCase());
        Elements nodeEl = node.children();
        for (Element nodeEl1 : nodeEl) {
            listDiv(nodeEl1);
        }

        return nodeEl;
    }
}
