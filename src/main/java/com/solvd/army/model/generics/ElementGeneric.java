package com.solvd.army.model.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElementGeneric<T>{
    private static final Logger LOGGER = LogManager.getLogger(ElementGeneric.class);
    private T data;
    public void ShowElement(){
        LOGGER.info(data);
    }

    public void setData(T t){
        this.data = t;
    }
    public T getData(){
        return this.data;
    }
}
