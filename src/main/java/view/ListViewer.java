package view;

import java.util.ArrayList;

public class ListViewer {
    private ArrayList<Viewable> list;

    public ListViewer(ArrayList<Viewable> list) {
        this.list = list;
    }

    public void display() {
        for (Viewable item : list) {
            System.out.println("-------------------------------------------");
            item.display();
        }
    }
}
