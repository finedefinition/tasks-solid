package finedefinition.model;

import java.math.BigDecimal;

public class Account {
    private String number;
    private BigDecimal amount;
    private Type type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" + "number='" + number + '\''
                + ", amount=" + amount + ", type=" + type + '}' + "\n";

    }

    public enum Type {
        REGULAR, GOLD, PLATINUM, USUAL
    }
}
