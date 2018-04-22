package com.company;

public class Node extends ListItem{

    public Node(Object value){
        this.value = value;
    }

    @Override
    ListItem next() {
        return this.rightlink;//field from the abstract class
    }

    @Override
    ListItem setNext(ListItem item) {
     this.rightlink = item;
        return this.rightlink;
    }

    @Override
    ListItem previous() {
        return this.leftlink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftlink = item;
        return this.leftlink;
    }

    @Override
    int compareTo(ListItem item) {//-1 if the item parameter which is so before the object
        if (item != null){
           return ((String) super.getValue()).compareTo((String)item.getValue());
        }else {//we have choose to parse in String (from all objects)
            return -1;
        }
    }
}
