/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity;

/**
 *
 * @author student
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public Iterator iterator(){
        return new LLIterator();
    }
    private class LLIterator implements Iterator{
        private Node nextNode;
        private boolean removeOK;
        private int postToRemove;
        
        private LLIterator(){
            nextNode = head;
            removeOK = false;
            postToRemove = -1;
        }
        public boolean hasNext(){
            return nextNode != null;
        }
        public Object next(){
            assert hasNext();
            
            Object result = nextNode.getData();
            nextNode = nextNode.getNext();
            
            removeOK = true;
            postToRemove++;
            
            return result;
        }
        public void remove(){
            assert removeOK;
            removeOK = false;
            LinkedList.this.remove(posToRemove);
            posToRemove--;
            
        }
    }
    public void makeEmpty(){
        head = tail= null;
        size = 0;
        
        
    }
    public Object remove(int pos){
        assert pos >= 0 && pos < size;
        Object result;
        if(pos == 0){
            result = head.getData();
            head = head.getNext();
            tail = null;
            
        }
        else{
            Node temp = head;
            for (int i = 1; i < pos; i++)
                temp = temp.getNext();
            result = temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
            if (pos == size - 1)
                tail = temp;
        }
        size--;
        return result;
    }
    public Object get(int pos){
        assert pos >= 0 && pos < size;
        Object result;
        if(pos == size - 1)
            result = tail.getData();
        else{
            Node temp = head;
            for (int i = 0; i < pos; i++)
                temp = temp.getNext();
            result = temp.getData();
        }
        return result;
    }
    public void insert(int pos, Object obj){
        assert pos >= 0 && <= size;
        if(pos == 0)
            addFirst(obj);
        else if (pos == size)
            add(obj);
        else{
            Node temp = head;
            for ( int i = 1; i < pos; i++)
                temp = temp.getNext();
            Node newNode = new Node(obj, temp.getNext());
            temp.setNext(newNode);
            size++;
        }
    }
    public void add(Object obj){
        Node newNode = new Node(obj, null);
        if(size == 0)
            head = newNode;
        else{
            tail.setNext(newNode);
        tail = newNode;
        size++;
        }
    }
    public void addFirst(Object obj){
        if(size == 0)
            add(obj);
        else{
            Node newNode = new Node(obj, head);
            head = newNode;
            size++;
        }
    }
    public String toString(){
        String result = "";
        Node temp = head;
        for(int i = 0; i < size; i++){
            result += temp.getData()+ " ";
            temp = temp.getNext();
        }
        return result;
    }
    
}
