package com.esdc.entity;


import com.esdc.warehouse.Observe;

public interface Observable {
    void addObserver(Observe observer);
    void removeObserver(Observe observer);


    void notifyObservers();
}