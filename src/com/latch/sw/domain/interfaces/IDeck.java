/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.sw.domain.interfaces;

import java.util.List;
import java.util.Properties;

/**
 *
 * @author admin
 * Those implement need to have a composition containning Cards
 * 
 */
public interface IDeck {
    
    public void shuffle();
    public void load() throws Exception;
    public List<ICard> getDeck();
    public void setDeck(List<ICard> ICardlst);
    public IHand getHand(Properties props) throws Exception;
    
    
    
}
