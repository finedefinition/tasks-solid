package finedefinition.dao;

import finedefinition.Main;
import finedefinition.model.Account;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountDaoCsvImpl implements AccountDao {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String FILE_NAME = "src/main/resources/database.csv";

    @Override
    public void add(Account account) {
        System.out.println(account);
    }

    @Override
    public Account get(String accountNumber) {
        logger.info("Method get was called");
        List<String> listAccounts = null;
        try {
            listAccounts = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("No such file");
        }

        logger.info(listAccounts);
        return listAccounts.stream().filter(line -> line.startsWith(accountNumber))
                .map(this::getFromCsvRow).findFirst().get();
    }

    private Account getFromCsvRow(String line) {
        logger.info("Method get was called");
        String[] fields = line.split(",");
        Account account = new Account();
        account.setNumber(fields[0]);
        account.setAmount(new BigDecimal(fields[1]));
        account.setType(Account.Type.valueOf(fields[2]));
        return account;
    }

    public void update(Account acc) {

    }

    public void printCsv() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = "";
            //Read the file line by line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(",");
                //Verify tokens
                System.out.println(Arrays.toString(tokens));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


