/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaltreeexample;

import java.util.Iterator;
import positionexample.Position;

/**
 *
 * @author Enubs
 */
public class GeneralTreeExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<String> tree1 = new GeneralTree<>("root1");
        Position t1c1 = tree1.addChild("t1c1");
        Position t1c2 = tree1.addChild("t1c2");
        Position t1c3 = tree1.addChild("t1c3");
        
        Iterable<Position<String>> iterable =
                tree1.positions();
        Iterator<Position<String>> iterator =
                iterable.iterator();
        
        while(iterator.hasNext()){
            System.out.print(iterator.next().getElement() + " ");
        }
        
        System.out.println("Size of Tree: " + tree1.size());
        
        GeneralTree<String> subtree1 = 
                new GeneralTree<>(t1c1, "subtree1");
        Position s1c1 = subtree1.addChild("s1c1");
        
        Iterable<Position<String>> iterable1 =
                subtree1.positions();
        Iterator<Position<String>> iterator1 =
                iterable1.iterator();
        
        while(iterator1.hasNext()){
            System.out.print(iterator1.next().getElement() + " ");
        }
        
        System.out.println("Size of SubTree: " + subtree1.size());
        System.out.println("Number of Tree1 Children: " + tree1.numChildren(tree1.root()));
        System.out.println("Size of Tree: " + tree1.height(s1c1));
        
    }

}
