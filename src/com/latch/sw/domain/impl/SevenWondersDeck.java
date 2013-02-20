/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.sw.domain.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.latch.sw.domain.interfaces.ICard;
import com.latch.sw.domain.interfaces.IDeck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SevenWondersDeck implements IDeck {

    private List<SevenWondersCard> swDeck = new ArrayList<SevenWondersCard>();
    
    
    
    @Override
    public void shuffle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<SevenWondersCard> getSwDeck() {
        return swDeck;
    }

    public void setSwDeck(List<SevenWondersCard> swDeck) {
        this.swDeck = swDeck;
    }
    
    public void addSwCardToDeck(SevenWondersCard swCard) {
        this.swDeck.add(swCard);
    }

    @Override
    public String toString() {
        return "SevenWondersDeck{" + "swDeck=\n" + swDeck + '}';
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @JsonIgnore
    @Override
    public List<ICard> getDeck() {
        return new ArrayList<ICard>(this.swDeck);
    }
    
    @JsonIgnore
    @Override
    public void setDeck(List<ICard> ICardlst) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    

    
    
    
}
