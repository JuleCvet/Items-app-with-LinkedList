package com.company;

public class Main {

    public static void main(String[] args) {

        MyLlinkedList list = new MyLlinkedList(null);
        list.traverse(list.getRoot());
        //String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String stringData = "1 3 5 9 0 4 6 8 2 5 7";

        String[] data = stringData.split(" ");
        for (String  s : data) {
            //the class which is extending from abstract
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());//printing the list
        list.removeItem(new Node("3"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("5"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("0"));
        list.removeItem(new Node("4"));
        list.removeItem(new Node("2"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("9"));
        list.traverse(list.getRoot());
        list.removeItem(new Node("8"));
        list.traverse(list.getRoot());
        list.removeItem(new Node("6"));
        list.traverse(list.getRoot());

        list.removeItem(list.getRoot());
        list.traverse(list.getRoot());
        list.removeItem(list.getRoot());
        list.traverse(list.getRoot());
    }
}
