package HW2;

public class BST {
	Node root;
	int size;
	
	public BST() {
		root=null;
	}
	
	
	Node insert(Node node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            node = new Node(key);
            return node;
        }
 
        // Otherwise, recur down the tree
        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
 
        // Return the (unchanged) node pointer
        return node;
    }
	
	Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == key)
            return root;
 
        // Key is greater than root's key
        if (root.data < key)
            return search(root.right, key);
 
        // Key is smaller than root's key
        return search(root.left, key);
    }
	
	void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

	}
	Node deleteNode(Node root, int key) {
        // Base case
        if (root == null)
            return root;
 
        // Recursive calls for ancestors of
        // node to be deleted
        if (root.data > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.data < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
 
        // We reach here when root is the node
        // to be deleted.
 
        // If one of the children is empty
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }
 
        // If both children exist
        else {
 
            Node succParent = root;
 
            // Find successor
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
 
            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;
 
            // Copy Successor Data to root
            root.data = succ.data;
 
            // Delete Successor and return root
            return root;
        }
    }
	
}
