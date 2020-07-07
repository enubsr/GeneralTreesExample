/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaltreeexample;

import positionexample.Position;

/**
 *
 * @author Enubs
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p){
        return numChildren(p) > 0;
    }
    
    @Override
    public boolean isExternal(Position<E> p){
        return numChildren(p) == 0;
    }
    
    public boolean isRoot(Position<E> p){
        return p == root();
    }
    
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }
    
    public int depth(Position<E> p){
        if(isRoot(p)){
            return 0;
        }
        else{
            return 1 + depth(parent(p));
        }
    }
    
    public int height(Position<E> p){
        int h = 0;
        
        //for(int i = 0; i < children(p).length; i++){
        // Position c = children(p);
        // h = Math.max(h, 1 + height(c));
        //}
        
        //foreach
        for(Position<E> c : children(p)){
            h = Math.max(h, 1 + height(c));
        }
        
        return h;
    }
}
