package org.jakk.hybridbackend;

import com.google.api.server.spi.config.*;
import org.jakk.hybridbackend.model.Account;
import org.jakk.hybridbackend.model.Location;
import org.jakk.hybridbackend.model.Transaction;
import org.jakk.hybridbackend.request.TransactionRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Api(name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "hybridbackend.jakk.org",
                ownerName = "hybridbackend.jakk.org",
                packagePath = ""),
        clientIds = {"endpoints.API_EXPLORER_CLIENT_ID"})
public class HybridAPI {

    private static final String[] DEMO_PARTNERS = {
            "Tesco",
            "Auchan",
            "Tigáz",
            "Telekom",
            "Miskolci Egyetem",
            "Misys",
    };

    @ApiMethod(
            path = "login",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void login() throws InterruptedException {
        sleep();
    }

    @ApiMethod(
            path = "atm",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public List<Location> getNearestAtms(Location userLocation) {
        sleep();

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int size = 5 + random.nextInt(5);
        List<Location> atmLocations = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            double latDiff = -0.02 + random.nextDouble(0.04);
            double lngDiff = -0.02 + random.nextDouble(0.04);
            atmLocations.add(new Location(userLocation.getLat() + latDiff, userLocation.getLng() + lngDiff));
        }
        return atmLocations;
    }

    @ApiMethod(
            path = "account",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public List<Account> getAccounts() {
        sleep();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int size = 1 + random.nextInt(2);
        List<Account> accounts = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            long accountId = random.nextLong(100);
            String accountName = "My account " + (i + 1);
            BigDecimal balance = BigDecimal.valueOf(random.nextLong(1_000_000));

            accounts.add(new Account(accountId, accountName, "HUF", balance));
        }
        return accounts;
    }

    @ApiMethod(
            path = "transaction",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public List<Transaction> getTransactions(TransactionRequest transactionRequest) {
        sleep();
        long accountId = transactionRequest.getAccountId();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int size = 10 + random.nextInt(20);
        List<Transaction> transactions = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            long trId = random.nextLong(100);
            String partner = DEMO_PARTNERS[random.nextInt(DEMO_PARTNERS.length)];
            BigDecimal amount = BigDecimal.valueOf(-10_000 + random.nextLong(20_000));
            transactions.add(new Transaction(trId, accountId, partner, amount, "HUF"));
        }
        return transactions;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //ignored
        }
    }
}
