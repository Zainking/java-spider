package model.reader;

import model.entities.RelatedUrlNews;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class UrlNewsReader {
    public static RelatedUrlNews read(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements titleEle = doc.select("title");

        String title = titleEle.first().text();
        String content = doc.select("meta[name=description]").attr("content");

        RelatedUrlNews news = new RelatedUrlNews(url, title, content);

        Elements relatedEles = doc.select(".timeline__item___2luxn");

        for (Element element : relatedEles) {
            String relatedTitle = element.select(".content-item___2j97j").text();
            Elements children = element.children();
            String relatedUrl = children.get(3).child(0).absUrl("href");

            news.addRelated(relatedTitle, relatedUrl);
        }

        return news;
    }
}
