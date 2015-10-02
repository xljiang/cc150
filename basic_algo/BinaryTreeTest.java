package basic_algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void test() {
		System.out.println("test1");
		BinaryTree tree = new BinaryTree();
		tree.build123c();
		tree.printPostorder();
		System.out.println(tree.size());
		tree.insert(5);
		tree.insert(10);
		System.out.println("maxDepth: " + tree.maxDepth());
		System.out.println("min");
		System.out.println("min: " + tree.minValue());

		BinaryTree tree2 = new BinaryTree();
		tree2.insert(4);
		tree2.insert(5);
		tree2.insert(2);
		tree2.insert(3);
		tree2.insert(1);
		tree2.printTree();

		tree2.printPaths();
		BinaryTree tree3 = new BinaryTree();
		tree3.insert(4);
		tree3.insert(5);
		tree3.insert(2);
		tree3.insert(3);
		tree3.insert(8);
		tree3.printTree();	
		System.out.println("sametree? " + tree2.sameTree(tree3));
		
	}
	
	
	@Test
	public void test2() {
		System.out.println("test2");

		BinaryTree tree = new BinaryTree();
		tree.build123c();
		tree.printTree();
		System.out.println(tree.size());
		tree.doubleTree();
		tree.printTree();
		System.out.println(tree.size());
		
		System.out.println(BinaryTree.countTrees(4));
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
		BinaryTree tree = new BinaryTree();

		tree.insert(4);
		tree.insert(5);
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		
		System.out.println(tree.isBST2());
	}

}
