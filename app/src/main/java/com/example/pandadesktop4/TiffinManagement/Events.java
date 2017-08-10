package com.example.pandadesktop4.TiffinManagement;

import java.util.Collection;

/**
 * Created by pandadesktop4 on 10/8/17.
 */
public enum  Events {
    Events;
    public static void fire(Collection<Executor> listeners){
        for(Executor runnable:listeners)
            runnable.run_me();
    }
}