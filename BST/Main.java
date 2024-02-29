package HW2;
import java.util.Scanner;


import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner user = new Scanner(System.in);
		Random random=new Random();
        BST tree = new BST();
        
        System.out.println("Enter number of elements you want to insert: ");
		int n = user.nextInt();
		int [] arr = new int[n];
		for(int i=0; i<n; i++) {
			int number= random.nextInt();
			arr[i]=number;
		}
		
		long start = System.currentTimeMillis();
		tree.root=tree.insert(tree.root, arr[0]);
		for(int i2=1; i2<n; i2++) {
			tree.insert(tree.root, arr[i2]);
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
			tree.search(tree.root,arr2[u2]);
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
			
			tree.deleteNode(tree.root, arr3[p2]);
		}
		long finish3 = System.currentTimeMillis();
		long timeElapsed3 = finish3 - start3;
		System.out.println(timeElapsed3);
		
		
 
       
        
	}

}
