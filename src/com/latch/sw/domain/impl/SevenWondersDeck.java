/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.sw.domain.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.latch.sw.domain.interfaces.ICard;
import com.latch.sw.domain.interfaces.IDeck;
import com.latch.sw.domain.interfaces.IHand;
import com.latch.sw.main.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author admin
 */
public class SevenWondersDeck implements IDeck {

    private List<SevenWondersCard> swDeck = new ArrayList<SevenWondersCard>();
    static Log log = LogFactory.getLog(Main.class.getName());
    
    
    
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
    public void load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SevenWondersDeck swDeck = mapper.readValue(new File("resources/swDeck.json"), SevenWondersDeck.class);
        log.info("swDeck = \n"+swDeck);
        log.info("Total Card in the deck is "+swDeck.getSwDeck().size());
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
        // iterate thru all List and makesure they are of type SevenWonderCard
        this.swDeck = new ArrayList<SevenWondersCard>();
        for (ICard card: ICardlst) {
            if (card instanceof SevenWondersCard) {
                swDeck.add((SevenWondersCard) card);
            }
        }
        
    }
    @JsonIgnore
    @Override
    public IHand getHand(Properties props) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    
    
    
}
