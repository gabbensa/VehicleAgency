package GUI;

import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
import java.awt.*;
import java.util.concurrent.locks.ReentrantLock;

import Vehicle.*;

public class Lock
{
    private static Map<Class<?>, ReentrantLock> locks;
    static {locks= new HashMap<>();}

    public static synchronized ReentrantLock getParentLocked(Class<?> vehicleClass)
    {
        Class<?> classCategory;
        if(SeaVehicle.class.isAssignableFrom(vehicleClass))
            classCategory=SeaVehicle.class;
        else if (LandVehicle.class.isAssignableFrom(vehicleClass))
            classCategory=LandVehicle.class;
        else if (AirVehicle.class.isAssignableFrom(vehicleClass))
            classCategory=AirVehicle.class;
        else
            classCategory=vehicleClass;

        return getLock(classCategory);

    }

    public static synchronized ReentrantLock getLock(Class<?> vehicleClass)
    {
        //System.out.println("Lock Thread: "+ Thread.currentThread().getId());
        if(!locks.containsKey(vehicleClass))
            locks.put(vehicleClass,new ReentrantLock());

        return locks.get(vehicleClass);
    }

    public static boolean checkLock()
    {
        for(ReentrantLock lock:locks.values())
            if(lock.isLocked())
                return true;
        return false;
    }

}
