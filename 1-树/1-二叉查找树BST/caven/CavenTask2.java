package algorithm;

import java.util.NoSuchElementException;


//二叉树的操作类
public class BiSearchTree {
public static BiSearchTNode root=new BiSearchTNode();

//create 创建二叉查找树
public static BiSearchTNode create(int[] number){
root.setData(number[0]);
for (int i = 1; i < number.length; i++) {
insert(number[i]);
}
return root;
}

//insert 插入一个新的值到已存在的二叉查找树中
public static void insert(int number) {
if (root.getData()>number){
add(number, root, root.getlChild(), 0);
}
else{
add(number, root, root.getrChild(), 1);
}
}
private static void add(int number, BiSearchTNode father, BiSearchTNode child, int tag) {
if (child == null) {
child = new BiSearchTNode(number);
if (tag == 0){
father.setlChild(child);
}
else{
father.setrChild(child);
}
} else {
if (number <= child.getData()){
add(number, child, child.getlChild(), 0);
}
else{
add(number, child, child.getrChild(), 1);
}

}
}

//search 通过值查找一个节点
public static BiSearchTNode search(int number) {
if (root.getData()>number) {
return find(number, root.getlChild());
} else {
return find(number, root.getrChild());
}
}
private static BiSearchTNode find(int number, BiSearchTNode tree) {
if (tree == null)
throw new NoSuchElementException("二叉树中不存在该值");
if (tree.getData()>number) {
return find(number, tree.getlChild());
} else if (tree.getData()<number) {
return find(number, tree.getrChild());
} else{
return tree;
}
}

//delete 通过值删除一个节点
//有点错误，到现在还没解决，先提交作业，就差这一个了。
public static BiSearchTNode delete(int number) {
return remove(number, root);
}
private static BiSearchTNode remove(int number, BiSearchTNode tree) {
if (tree == null)
throw new NoSuchElementException("二叉树中不存在该值");
if (tree.getData()>number) {
remove(number, tree.getlChild());
} else if (tree.getData()<number) {
remove(number, tree.getrChild());
} else{
deleteAll(tree);
}
return tree;
}
private static void deleteAll(BiSearchTNode tree) {
if(tree!=null){
deleteAll(tree.getlChild());
deleteAll(tree.getrChild());
tree=null;
}
}

//中序遍历
public static void InOrderTraverse(BiSearchTNode node){
if(node!=null){
InOrderTraverse(node.getlChild());
System.out.print(node.getData()+" - ");
InOrderTraverse(node.getrChild());
}
}

public static void main(String [] args) throws Exception{
System.out.println("===创建树===");
int[] ints={5, 9, 2, 1, 4, 7, 6, 8};
create(ints);
InOrderTraverse(root);
System.out.println("");
System.out.println("===插入一个新的值 3===");
insert(3);
InOrderTraverse(root);
System.out.println("");
System.out.println("===查找一个值 4===");
BiSearchTNode tree=search(4);
System.out.println(tree.getData());
System.out.println("===删除一个值 3===");
InOrderTraverse(delete(3));
}
}

//二叉树对象
class BiSearchTNode{
private int data;
private BiSearchTNode lChild=null;
private BiSearchTNode rChild=null;

public BiSearchTNode() {
}

public BiSearchTNode(int data){
this.data = data;
}

public BiSearchTNode(int data,BiSearchTNode lChild,BiSearchTNode rChild){
this.data = data;
this.lChild = lChild;
this.lChild = lChild;
}


public int getData() {
return data;
}

public BiSearchTNode getlChild() {
return lChild;
}

public void setlChild(BiSearchTNode lChild) {
this.lChild = lChild;
}

public BiSearchTNode getrChild() {
return rChild;
}

public void setrChild(BiSearchTNode rChild) {
this.rChild = rChild;
}

public void setData(int data) {
this.data = data;
}



}