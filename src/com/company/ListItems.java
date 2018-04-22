package com.company;

abstract class ListItem {

    protected ListItem rightlink = null; //references of object ListItem: ListItem for the right link
    protected ListItem leftlink = null;//instance's of same class with in the class

    protected Object value; //to hold a Value

    public ListItem (Object value){//constructor that sets the value
        this.value = value;
    }

    protected ListItem() {
    }

    abstract ListItem next();//return the reference to the next item in the list
    abstract ListItem setNext(ListItem item);//sets the reference to the nextItem to reefer to in the parameter item which is paced
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);//sets the reference to the previousItem to reefer to the parameter Item which is paced

    abstract int compareTo(ListItem item);
//compare the object to the Item(paced like parameter), return 0 if ==, -1 or 1, compare field by field
//protected, so we can access them from subclass(which will extends from this one), with in this package
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
