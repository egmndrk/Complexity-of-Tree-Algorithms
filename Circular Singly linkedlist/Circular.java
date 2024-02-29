package HW2_3;
import java.util.Scanner;
import java.util.Random;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node tail;

    public CircularLinkedList() {
        this.tail = null;
    }

    
    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            
            tail = newNode;
            tail.next = tail; 
        } else {
           
            newNode.next = tail.next; 
            tail.next = newNode; 
            tail = newNode; 
        }
    }

    
    public void deleteFromEnd() {
        if (tail == null) {
           
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        Node current = tail;
        while (current.next != tail) {
            
            current = current.next;
        }

        
        current.next = tail.next;

        
        tail = current;
    }
    
    public void search(int value) {
        if (tail == null) {
            
            System.out.println("List is empty. Value not found.");
            return;
        }

        Node current = tail.next; 
        do {
            if (current.data == value) {
                
                
                return;
            }
            current = current.next;
        } while (current != tail.next);

       
       
    }
    public void deleteNode(int value) {
        if (tail == null) {
          
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        Node current = tail.next; 
        Node prev = null;

       
        do {
            if (current.data == value) {
               
                if (prev == null) {
                   
                    tail.next = current.next; 
                } else {
                    
                    prev.next = current.next; 
                    if (current == tail) {
                       
                        tail = prev;
                    }
                }
                return; 
            }

            prev = current;
            current = current.next;
        } while (current != tail.next);

      
        
    }

    
    public void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = tail.next; 
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}

public class Circular {
    public static void main(String[] args) {
    	Scanner user = new Scanner(System.in);
		Random random=new Random();
        CircularLinkedList circularList = new CircularLinkedList();
        
        System.out.println("Enter number of elements you want to insert: ");
		int n = user.nextInt();
		int [] arr = new int[n];
		for(int i=0; i<n; i++) {
			int number= random.nextInt();
			arr[i]=number;
		}
		long start = System.currentTimeMillis();
		for(int i2=0; i2<n; i2++) {
			circularList.addToEnd(arr[i2]);
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println(timeElapsed);


       
		System.out.println("Enter the number of elements you want to search: ");
		int m=user.nextInt();
		int [] arr2 = new int[m];
		for(int u=0; u<m; u++) {
			int number2= random.nextInt();
			arr2[u]=number2;
		}
		long start2 = System.currentTimeMillis();
		
		
		for(int u2=0; u2<m; u2++) {		
			circularList.search(arr2[u2]);
		}
		
		long finish2 = System.currentTimeMillis();
		long timeElapsed2 = finish2 - start2;
		System.out.println(timeElapsed2);

		System.out.println("Enter the number of elements you want to delete: ");
		int d=user.nextInt();
		int [] arr3 = new int[d];
		for(int p=0; p<d; p++) {
			int number3= random.nextInt();
			arr3[p]=number3;
		}
		long start3 = System.currentTimeMillis();
		for(int p2=0; p2<d; p2++) {
			
			circularList.deleteNode(arr3[p2]);
		}
		long finish3 = System.currentTimeMillis();
		long timeElapsed3 = finish3 - start3;
		System.out.println(timeElapsed3);
		
       
    }
}
