package model.entities;

import java.util.HashMap;
import java.util.Map;

public class RelatedUrlNews extends UrlNews {
    private HashMap<String, String> relateds = new HashMap();

    public RelatedUrlNews(String title, String content, String url) {
        super(title, content, url);
    }

    public void addRelated(String title, String url) {
        this.relateds.put(title, url);
    }

    public HashMap<String, String> getRelateds() {
        return relateds;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("|Related|");
        for(Map.Entry<String, String> entry : relateds.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
