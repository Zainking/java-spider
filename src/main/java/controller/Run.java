package controller;

import model.entities.RelatedUrlNews;
import model.reader.UrlNewsReader;
import view.ListViewer;
import view.Viewable;

import java.util.*;

public class Run {
    static final int maxURLNum = 10;

    public static void start() throws Exception {
        String startUrl = "https://readhub.me/topic/5bMmlAm75lD";

        RelatedUrlNews startNews = UrlNewsReader.read(startUrl);

        int count = 0;

        Set<String> visited = new HashSet<String>();
        visited.add(startUrl);

        Queue<RelatedUrlNews> newsQueue = new LinkedList();
        newsQueue.add(startNews);

        ArrayList<Viewable> results = new ArrayList();

        while(!newsQueue.isEmpty() && count <= maxURLNum) {
            RelatedUrlNews current = newsQueue.poll();
            results.add(current);
            count++;
            for (Map.Entry<String, String> entry : current.getRelateds().entrySet()) {
                String url = entry.getValue();
                RelatedUrlNews next = UrlNewsReader.read(url);
                if (!visited.contains(url)) {
                    newsQueue.add(next);
                    visited.add(url);
                }
            }
        }

        new ListViewer(results).display();
    }
}
