package com.example.limit_service.beans;

public class Limits {

    private long minimum;
    private long maximum;

    public Limits(long minimum,long maximum){
        super();
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public long getMinimum() {
        return minimum;
    }

    public long getMaximum() {
        return maximum;
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(long maximum) {
        this.maximum = maximum;
    }
}
