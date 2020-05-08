package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println("****-Normal List-****");
        list.printList();
        System.out.println("\n-----------------------");
        System.out.println("-----------------------");
        int x =list.getKthNodeFromTheEnd(3);
        System.out.println(x);

        //
    }
}
