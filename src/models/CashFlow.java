package models;

import java.util.Date;

public class CashFlow {
    private final Date date;
    private final double value;
    private final CashFlowRate rate;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public CashFlow(final Date date, final double value, final CashFlowRate rate) {
        this.date = date;
        this.value = value;
        this.rate = rate;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public CashFlowRate getRate() {
        return rate;
    }
}