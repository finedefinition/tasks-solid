package finedefinition;

import finedefinition.dao.AccountDaoCsvImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Method main was called");

        AccountDaoCsvImpl accountDaoCsv = new AccountDaoCsvImpl();
        //accountDaoCsv.printCsv();
        System.out.println(accountDaoCsv.get("10100"));
    }
}
