/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.sw.domain.impl;

import com.latch.sw.domain.interfaces.ICard;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SevenWondersCard implements ICard {

    private String name;
    private String type;
    private List<String> cost = new ArrayList<String>();
    private String freeChain;
    private List<String> chainProduction = new ArrayList<String>();
    private Integer config;
    private String age;
    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCost() {
        return cost;
    }

    public void setCost(List<String> cost) {
        this.cost = cost;
    }
    
    public void addCost(String cost) {
        this.cost.add(cost);
    }

    public List<String> getChainProduction() {
        return chainProduction;
    }

    public void setChainProduction(List<String> chainProduction) {
        this.chainProduction = chainProduction;
    }
    
    public void addChainProduction(String chainProduction) {
        this.chainProduction.add(chainProduction);
    }

    public Integer getConfig() {
        return config;
    }

    public void setConfig(Integer config) {
        this.config = config;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFreeChain() {
        return freeChain;
    }

    public void setFreeChain(String freeChain) {
        this.freeChain = freeChain;
    }
    
    
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "SevenWondersCard{" + "name=" + name + ", type=" + type + ", cost=" + cost + ", freeChain=" + freeChain + ", chainProduction=" + chainProduction + ", config=" + config + ", age=" + age + ", action=" + action + '}' + "\n";
    }
    
}
