package com.solvd.army.model.generics;

import java.util.logging.Logger;

public class MyGenericClass<U> {
    public static final Logger LOGGER = Logger.getLogger(MyGenericClass.class.getName());

    public void takeEntity(U u) {
        LOGGER.info(String.valueOf(u));
    }

}
