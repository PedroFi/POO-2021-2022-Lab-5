package models;

import java.util.Date;

public class CashFlowRate {
    private final Date date;
    private final double value;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public CashFlowRate(final Date date, final double value) {
        this.date = date;
        this.value = value;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}