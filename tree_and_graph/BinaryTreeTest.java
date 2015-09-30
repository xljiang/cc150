package tree_and_graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void test() {
		BinaryTree tree = new BinaryTree();
		tree.build123c();
		tree.print123();
		System.out.println(tree.size());
		tree.insert(5);
		tree.insert(10);
		System.out.println(tree.maxDepth());
	}

}
