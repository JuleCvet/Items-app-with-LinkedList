package com.company;

public class MyLlinkedList implements  NodeList {

    private ListItem root = null;

    public MyLlinkedList(ListItem root){
        this.root = root;
    }

    public MyLlinkedList() {
        super();
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {//check for the empty list first, and add new Item at the head of the list
//if the list is not empty, we should compare each item with the new item to know where certain item should be insert
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
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }else if(comparison > 0){ //new item is less, then insert before
                if (currentItem.previous() != null){
                    currentItem.previous().setNext(newItem);//on previous Item set newItem
                    newItem.setPrevious(currentItem.previous());//from that position, set currentItem.previous() like previous
                    newItem.setNext(currentItem);// and currentItem like next
                    currentItem.setPrevious(newItem);
                }
                    else {//for >0, when newItem is less
                    //the node with a previous is the root, there is no previous, we should make NewItem
                    newItem.setNext(this.root).setPrevious(newItem);//pointing to the currently new record
                   //previous pointing out to the newItem
                    this.root = newItem;//the head of the list to become newItem
                }
                return true;
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
    public boolean removeItem(ListItem item) {
  //we reverse the list until we find the item that we want to remove,
  //then we set the previous link to point to where the item that be deleted points
      if (item != null){
          System.out.println("Deleting item " + item.getValue());
      }

      ListItem currentItem = this.root;//very first entry
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if (comparison == 0){//if the root is matching with the comparison item,
                //found the record to delete! We must to be sure that we will set next item to be root
                if(currentItem == this.root){
                    this.root = currentItem.next();
                }else{
                    currentItem.previous().setNext(currentItem.next());
//setting the privious to currently next item after deleting, and we are testing under for previous also
//making sure that the both previous&next are pointing to the right places
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if(comparison < 0){
//we want to continue navigating try the Linked List  to see if we can find the record
                currentItem = currentItem.next();
            }else { //(comparison > 0) it means we have passed the point for deleting
//we are at an item greater than the one to be deleted, so the item is not in the list
                return false;
            }
        }
//we have reached the end of the list, without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
                //to see if we have some data
        if (root == null){
            System.out.println("The list is empty.");
        }else{
             while (root != null){
                System.out.println(root.getValue());
                root = root.next();//output the code
        }
      }

        //traverse with binary search
//        if (root != null){
//            System.out.println(root.getValue());
//            traverse(root.next());
//            //9 000 000 000 000 000 000 nodes, it will take 63 levels to go try all that records
//        }
    }
}
