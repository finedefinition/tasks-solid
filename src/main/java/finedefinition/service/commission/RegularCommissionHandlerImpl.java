package finedefinition.service.commission;

import java.math.BigDecimal;

public class RegularCommissionHandlerImpl implements CommissionHandler {
    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        return amount.multiply(new BigDecimal(0.01));
    }
}
