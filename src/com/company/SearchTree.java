package com.company;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root){
        this.root = root;
    }
//implementing a binary search tree instead of a LinkedList. Is visiting every node to the left and to the right also
 //recursive function is any definition which includes object in its own definition
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            //the list is empty, so this item become the head
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;//starting to compare from the head of the list
        while (currentItem != null){//if it is null, there is no more entries to go throw in
            int comparison = (currentItem.compareTo(newItem));
            if(comparison < 0){//it is -1, not equal
                //newItem is greater, so move right if possible
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    //there is no next, so insert at end of the list newItem, and previous current
                    currentItem.setNext(newItem);
                    return true;
                }
            }else if(comparison > 0){ //new item is less, then insert before
                if (currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }
                else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }
            else {
                //if they are equal, we don't want to add them
                System.out.println(newItem.getValue() + " is already present, not added. ");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {  //finding the item which should be deleted& we have also reference to his parent
        if (item!=null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0){//everything to the left is smaller then "item"
                parentItem = currentItem;
                currentItem = currentItem.next();
            }else if (comparison > 0){
                parentItem = currentItem;//set to point to it
                currentItem = currentItem.previous();
            }else{
                //equal: we've found the item, so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }


    private void performRemoval(ListItem item, ListItem parent){  //remove item from the tree
        if (item.next() == null){ //no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item){ //item is right child of its parent
                parent.setNext(item.previous());
            }else if (parent.previous() == item){  //item is left child of its parent
                parent.setPrevious(item.previous());
            }else {  //parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        }else if (item.previous() == null){  //no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item){  //item is right child of its parent
                parent.setNext(item.next());
            }else if (parent.previous() == item){  //item is left child of its parent
                parent.setPrevious(item.next());
            }else {   //again we are deleting the root
                this.root = item.next();
            }
        }else {  //neither left nor right are null, deletion is now a lot trickier.
  //from the right sub-tree, find the smallest value (i.e., the leftmost)
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null){
                leftmostParent = current;
                current = current.previous();
            }  //now put the smallest value into our node to be deleted
            item.setValue(current.getValue());  //and delete the smallest
            if (leftmostParent == item){  //there was no leftmost node, so 'current' points to the smallest node. the one that must now be deleted!
                item.setNext(current.next());
            }else {  //set the smallest node's parent to point to the smallest node's right child (which may be null)
                leftmostParent.setPrevious(current.next());
            }
        }

    }

    @Override
    public void traverse(ListItem root) {
        //recursive method is calling it self
        if (root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
