package active;

import model.entities.RelatedUrlNews;
import model.reader.UrlNewsReader;

import java.io.IOException;
import java.util.Queue;
import java.util.Set;

public class SpiderThread extends Thread {
    private String url;
    private Set visited;
    private Queue newsQuene;

    public SpiderThread(String url, Set visited, Queue newsQuene) {
        super();

        this.url = url;
        this.visited = visited;
        this.newsQuene = newsQuene;

        start();
    }

    public void run() {
        try {
            RelatedUrlNews next = UrlNewsReader.read(url);
            if (!visited.contains(url)) {
                newsQuene.add(next);
                visited.add(url);
            }
        } catch (IOException e) {
            System.out.println("There is an error in " + url);
        }

    }
}
