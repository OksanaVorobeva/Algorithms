package lesson3;

import org.w3c.dom.Node;

public class Task {
    Node head;
    Node tail;

    public  void push(int value){
        Node node = new Node();
        node.value=value;
        node.next=head;
        head.previous=node;
        head=node;
    }

    public  Integer peek(){
        Integer result = null;
        if (tail!=null){
            result=tail.value;
            tail.previous.next=null;
            tail = tail.previous;
        }
        return  result;
    }

    public  void  add(int value){
        Node node= new Node();
        node.value = value;
        if (head==null){
            head =node;
            tail = node;
        }else {
            tail.next=node;
            node.previous = tail;
            tail=node;
        }
    }

    public  void  add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value= value;
        node.next= newNode;
        newNode.previous=node;
        if(next==null){
            tail=newNode;
        }else {
            next.previous=newNode;
            newNode.next=next;
        }
    }

    public  void delete(Node node){
        Node previos = node.previous;
        Node next = node.next;
        if (previos==null){
            node.next.previous=null;
            head =next;
        }else {
            if(next==null){
                previos.next= null;
                tail=previos;
            }else {
                previos.next=next;
                next.previous=previos;
            }
        }
    }

    public Node find(int value){
        Node currentNode = head;
        while (currentNode !=null){
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void revert(){
        Node currentNode=head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next=previous;
            currentNode.previous=next;
            if (previous==null){
               tail=currentNode;
            }
            if (next==null){
                head=currentNode;
            }
            currentNode=next;
        }
    }
    public  class Node{
        int value;
        Node next;

        Node previous;
    }
}
