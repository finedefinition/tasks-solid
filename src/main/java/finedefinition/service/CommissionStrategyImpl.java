package finedefinition.service;

import finedefinition.model.Account;
import finedefinition.service.commission.CommissionHandler;
import java.util.Map;

public class CommissionStrategyImpl implements CommissionStrategy {
    private Map<Account.Type, CommissionHandler> commissionHandlerMap;

    public CommissionStrategyImpl(Map<Account.Type, CommissionHandler> commissionHandlerMap) {
        this.commissionHandlerMap = commissionHandlerMap;
    }

    @Override
    public CommissionHandler get(Account.Type type) {
        return commissionHandlerMap.get(type);
    }
}
