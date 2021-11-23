package com.solvd.army.model.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyGenericClass<U> {
    public static final Logger LOGGER = LogManager.getLogger(MyGenericClass.class);

    public void takeEntity(U u) {
        LOGGER.info(u);
    }

}
