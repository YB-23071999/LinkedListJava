package com.company;

import java.util.NoSuchElementException;
import java.util.Objects;


public class LinkedList {


    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    //isEmpty()
    private boolean isEmpty(){
        return first == null;
    }

    //addFirst
    public void addFirst(int item){
        Node node = new Node(item);

        if(first == null)
        { first = last = node;
            size++;
        }

        else{
            node.next = first;
            first = node;
            size++;
        }


    }

    //addLast
    public void addLast(int item){
        Node node = new Node(item);

        if(first==null)
        {   first = last = node;
            size++;
        }

        else{
            last.next = node;
            last = node;
            size++;
        }
    }

    //deleteFirst
    public void deleteFirst(){
        // if LinkedList is empty
        if(isEmpty())
            throw new NoSuchElementException();
        //if LinkedList contains only one element
        if(first == last)
        { first = last = null;
            size--;}
        //if LinkedList contains more than 1 item
        else{
          var  agent_node = first.next;
            first.next = null;
            first = agent_node;
            size--;
        }
    }

    //deleteLast
    public void deleteLast(){
        // if LinkedList is empty
        if(isEmpty())
            throw new NoSuchElementException();
        //if LinkedList contains only one element
        if(first == last)
        {   first = last = null;
            size--;}
        else{
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
            size--;

        }
 }

    // This method is used to get the address of the previous node of the given Node while invoking this method.
    private Node getPrevious(Node node) {
        var  current = first;
        while(current != null){
            if (current.next == node)
                return current;

            current = current.next;
        }
        return null;
    }

    //contains
    public boolean containsItem(int item){
        return indexOf(item) != -1;
    }

    //indexof
    public int indexOf(int item){
        int index = 0;
        var current = first;
        while(current != null){
            if(current.value == item)
                return index;

            current = current.next;
            index++;
        }
        return -1;
    }

    //size
    public int size(){
        return size;
    }

    //toArray
    public int[] toArray(){
        int[] array = new int[size];
        int index = 0;
        var current = first;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    //reverse
    //10->20->30->40->50  to be solved--> 50->40->30->20->10
    // f   c           l                   f               l
    // p
    public void reverse(){
        Node current = first;
        Node previous = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        first = previous;
//        first.next=null;
//        next = first;
//        first = last;
//        last = next;

    }
    //printList
    void printList()
    {   var node = first;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    //getKthNodeFromTheEnd
    public int getKthNodeFromTheEnd(int k){
        if (isEmpty()){
            throw new IllegalStateException();
        }
        var pointer_1 = first;
        var pointer_2 = first;

        for(int i = 0; i < k-1; i++){
            pointer_2 = pointer_2.next;

            if(pointer_2.next == null)
                throw new IllegalArgumentException();
        }
        while(pointer_2 != last){
           pointer_1 = pointer_1.next;
           pointer_2 = pointer_2.next;
        }
        return pointer_1.value;
    }
    //End of Class
}
