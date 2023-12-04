package project212;

/*
CLASS: contactBST
CSC212 Data structures - Project phase II
Fall 2023
EDIT DATE:
11-03-2023
TEAM:
Abdalaziz Almutairi
Ibrahim Althanyyan
Abdullah Alomran
AUTHORS:
Abdalaziz Almutairi (443101720)
Ibrahim Althanyyan  (443101693)
Abdullah Alomran    (443100868)
*/
public class contactBST {
	  
    BSTNode  root, current;
    boolean found;
    public contactBST() {
            root = current = null;
    }

    public void searchByName(String name) { 
		BSTNode q = current;
		if (!findKey(name)) {
			System.out.println("Contact is not found!");
			current=q; //since findKey changes the current
			return;
		}
		else {
			System.out.println("Contact found!");
			System.out.println(current.data.toString());
		}
			
	}

    public BSTNode findByName(String name) { 
        BSTNode q = current;
        if (!findKey(name)) {
            System.out.println("Contact is not found!");
            current = q; //since findKey changes the current
            return null;
        }
        else {
            return current;
        }

    }

	public void searchByPhoneNumber(String phoneNumber , BSTNode node) { 
		if (node == null)
			return ;
		searchByPhoneNumber(phoneNumber , node.left);
		if (((Contact)node.data).getPhone_number().equals(phoneNumber)) {
			System.out.println("contact found!");
			System.out.println(((Contact)node.data).toString());
			found=true ;
		}
		searchByPhoneNumber(phoneNumber , node.right);
		
	}

    public void searchByEmailAddress(String emailAddress , BSTNode node) {

        if (node == null)

            return;

        searchByEmailAddress (emailAddress , node.left);

        if (((Contact)node.data).getEmail().equals(emailAddress)) {

            System.out.println("contact found!");

            System.out.println(((Contact)node.data).toString());
            found=true ;

        }

        searchByEmailAddress (emailAddress , node.right);

    }

    public void searchByAddress(String address , BSTNode node) {

        if (node == null)

            return;

        searchByAddress (address , node.left);

        if (((Contact)node.data).getAddress().equals(address)) {

            System.out.println("contact found!");

            System.out.println(((Contact)node.data).toString());
            found=true ;

        }

        searchByAddress (address , node.right);

    }

    public void searchByBirthday(String birthday , BSTNode node) {

        if (node == null)

            return;

        searchByBirthday (birthday , node.left);

        if (((Contact)node.data). getBirthday().equals(birthday)) {

            System.out.println("contact found!");

            System.out.println(((Contact)node.data).toString());
            found=true ;

        }

        searchByBirthday (birthday , node.right);

    }

    public boolean empty() {
            return root == null;
    }

    public boolean full() {
            return false;
    }

    public Contact retrieve () {
            return current.data;
    }

    public boolean findKey(String keyToFind) {
            BSTNode p = root , q = root;

            if(empty())
                    return false;

            while(p != null) {
                    q = p;
                    if(p.key.compareTo(keyToFind) == 0) {//comparing (p.key,keyToFind);
                            current = p;
                            return true;
                    }
                    else if(keyToFind.compareTo(p.key) < 0)//comparing (keyToFind,p.key);
                            p = p.left;
                    else
                            p = p.right;
            }
            current = q;
            return false;
    }
    public void insert(Contact c ){
        BSTNode hold = current;
        BSTNode nodeToAdd = new BSTNode (c.getContact_name(),c );
        if (empty()) {
            root = current = nodeToAdd;
            
            return;
        }
        if (c.getContact_name().compareTo(current.key) < 0)
               current.left = nodeToAdd;
        else
              current.right = nodeToAdd;
            current = nodeToAdd;
           
    }
    public void insert2(Contact c) {
        root = insertRec(root, c.getContact_name() ,c);
    }
    private BSTNode insertRec(BSTNode root, String key, Contact data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new BSTNode(key, data);
            return root;
        }

        // Otherwise, recur down the tree
        int compareResult = key.compareTo(root.key);
        
        if (compareResult < 0) {
            root.left = insertRec(root.left, key, data);
        } else if (compareResult > 0) {
            root.right = insertRec(root.right, key, data);
        }

        // Return the (unchanged) node pointer
        return root;
    }
    public boolean findPhoneNumber(String PhoneNumber, BSTNode pointer){
        if (pointer == null)
            return false;

        // First recur on left subtree
        if (findPhoneNumber(PhoneNumber,pointer.left))
            return true;

        // Now deal with the node
        if(PhoneNumber.compareTo(pointer.data.getPhone_number()) == 0)
            return true;
        // Then recur on right subtree
        if(findPhoneNumber(PhoneNumber,pointer.right))
            return true;

        return false;
    }

    public void printContact(BSTNode pointer){//printing inorder for testing purposes
        if (pointer == null)
            return;

        // First recur on left subtree
        printContact(pointer.left);

        // Now deal with the node
        System.out.println(pointer.data.toString());

        // Then recur on right subtree
        printContact(pointer.right);

    }

    // Method to delete a node with the given key from the BST
    public void deleteC(String key) { 
        root = deleteRec(root, key);
    }

    private BSTNode deleteRec(BSTNode root, String key) {
        if (root == null) {
            return root;
        }

        // Search for the node to be deleted
        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            root.key = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private String minValue(BSTNode root) {
        String minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
}