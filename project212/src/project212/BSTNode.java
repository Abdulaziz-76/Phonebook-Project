package project212;

/*
CLASS: BSTNode
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
class BSTNode {
    
    public String key;
        public Contact data;
        public BSTNode right, left;


    public BSTNode() {
            right = left = null;
        }

            public BSTNode(String key, Contact data) {
            this.key = key  ;
            this.data = data;
            right = left = null;
        }

            public BSTNode(String key, Contact data, BSTNode l, BSTNode r){
            this.key = key  ;
            this.data = data;
            left = l;
            right = r;
        }

}
