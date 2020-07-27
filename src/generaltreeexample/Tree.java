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
 * @param <E>
 */
public interface Tree<E> extends Iterable<E> {
    public Position<E> root();
    public Position<E> parent(Position<E> p) 
            throws IllegalArgumentException;
    public Iterable<Position<E>> children(Position<E> p) 
            throws IllegalArgumentException;
    public int numChildren(Position<E> p) 
            throws IllegalArgumentException;
    public boolean isInternal(Position<E> p) 
            throws IllegalArgumentException;
    public boolean isExternal(Position<E> p) 
            throws IllegalArgumentException;
    
    public int size();
    public boolean isEmpty();
    @Override
    public Iterator<E> iterator();
    
    public Iterable<Position<E>> positions();
}
