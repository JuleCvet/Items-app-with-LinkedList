package com.company;

public interface NodeList {

    ListItem getRoot();//the head of the list, applies to binary search
    boolean addItem (ListItem item);
    boolean removeItem (ListItem item);
    void traverse (ListItem root);//print all values in the structure
}
