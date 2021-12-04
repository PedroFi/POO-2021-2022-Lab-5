package models;

public class IdentificationType {
    private final String name;
    private final String symbol;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public IdentificationType(final String name, final String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
