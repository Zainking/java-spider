package model.entities;

import view.Viewable;

public class News implements Viewable {
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void display() {
        System.out.println("|Title|" + title);
        System.out.println("|Content|" + content);
    }
}
