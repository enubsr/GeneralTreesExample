/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaltreeexample;

import java.util.ArrayList;
import java.util.Iterator;
import positionexample.Position;

/**
 *
 * @author Enubs
 * @param <E>
 */
public final class GeneralTree<E> extends AbstractTree<E>{
    
    public static class Node<E> implements Position<E>{
        private Node<E> parent;
        private E element;
        private ArrayList<Position<E>> children;
        
        public Node(Node<E> parent, E element, ArrayList<Position<E>> children){
            this.parent = parent;
            this.element = element;
            this.children = children;
        }
        
        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public ArrayList<Position<E>> getChildren() {
            return children;
        }

        public void setChildren(ArrayList<Position<E>> children) {
            this.children = children;
        }
    }//end of class Node
    
    //THE GENERAL TREE IMPLEMENTATION
    private int size;
    private Node<E> parent;
    private final ArrayList<Position<E>> children;
    private Node<E> root = null;
    
    public GeneralTree(E element){
        this(null, element);
        size = 1;
    }
    
    public GeneralTree(Position<E> parent, E element){
        children = new ArrayList<>();
        
        Node<E> newNode = new Node<>
                ((Node<E>) parent, element, children);
        
        this.root = newNode;
        
    }
    
    public Position<E> addChild(E e){
        Node<E> newChild = new Node<>(root, e, null);
        children.add(newChild);
        size++;
        return newChild;
    }
    
    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) 
            throws IllegalArgumentException {
        return ((Node<E>)p).getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) 
            throws IllegalArgumentException {
        return positions();
    }

    @Override
    public int numChildren(Position<E> p) 
            throws IllegalArgumentException {
        return ((Node<E>)p).getChildren().size();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) positions().iterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return (Iterable<Position<E>>) children;
    }
    
    @Override
    public int height(Position<E> p){
        return super.height(p);
    }
    
    @Override
    public int depth(Position<E> p){
        return super.height(p);
    }
}
