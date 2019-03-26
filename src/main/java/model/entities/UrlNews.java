package model.entities;

public class UrlNews extends News {

    private String url;

    public UrlNews (String title, String content, String url) {
        super(title, content);
        this.url = url;
    }

    public String getUrl() { return url; }

    @Override
    public void display() {
        super.display();
        System.out.println("|URL|" + url);
    }
}
