package de.holisticon.tracee.carbookingsample.model;

/**
 * Created by dennis on 06.03.14.
 */
public class NumberGenerator {

    Class Entity;
    long lastNumber;
    long delta = 10l;

    public Class getEntity() {
        return Entity;
    }

    public void setEntity(Class entity) {
        Entity = entity;
    }

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public long getDelta() {
        return delta;
    }

    public void setDelta(long delta) {
        this.delta = delta;
    }
}
