package com.ally.invoicify.models;

import java.util.List;

public class InvPerMonth {
    private String month;
    private int value;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public InvPerMonth(String month, int value) {
        this.month = month;
        this.value = value;
    }
}