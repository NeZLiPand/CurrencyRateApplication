package ua.open.api.andry.inkin.currencyrate.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ua.open.api.andry.inkin.currencyrate.controller.parser.Parser;
import ua.open.api.andry.inkin.currencyrate.controller.validator.Validator;
import ua.open.api.andry.inkin.currencyrate.controller.workingwithfiles.CRUDFile;
import ua.open.api.andry.inkin.currencyrate.model.Model;
import ua.open.api.andry.inkin.currencyrate.model.domain.CurrencyRate;

//Зробити нормальну документацію к методам

public class Controller {
    private Validator validator;
    private Parser parser;
    private CRUDFile crudFile;
    private Model model;

    public Controller(Builder builder) {
        this.validator = builder.validator;
        this.parser = builder.parser;
        this.crudFile = builder.cRUDFile;
        this.model = builder.model;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void processingRequest() {
//        Need to implement this method, but there is only a nice name,
//          but what this method should do is still not clear.
    }

    public Map<String, String> provideRelevanceCurrenciesCodes() throws IOException {
        validator.validate();

        Map<String, String> currenciesCodes = model.getCurrenciesCodes();
        if (currenciesCodes.size() == 0) {
            currenciesCodes = new HashMap<>();
            Elements parsedCurrenciesCodes = parser.parseMinfinCurrenciesCodes();
            for (Element curencyCode : parsedCurrenciesCodes) {
                currenciesCodes.put(curencyCode.select("Code")
                                               .text(), curencyCode.select("letters")
                                                                   .text());
            }
            model.setCurrenciesCodes(currenciesCodes);
        }
        return currenciesCodes;
    }

    public List<CurrencyRate> provideRelevanceCurrenciesRates() throws IOException {
        validator.validate();
        long dateTimeOfTheMostRecentRate = model.getDateAndTimeOfTheMostRecentRate();
        long actualDateTime = System.currentTimeMillis() / 1000L;
        if (300L >= (actualDateTime - dateTimeOfTheMostRecentRate)) {
            System.out.println("Rates are relevant");
            return model.getCurrenciesRates();
        } else {
            System.out.println("Rates aren`t relevant "
                               + actualDateTime
                               + "-"
                               + dateTimeOfTheMostRecentRate
                               + "="
                               + (actualDateTime - dateTimeOfTheMostRecentRate)/60);
            List<CurrencyRate> currenciesRates = provideCurrenciesRates();
            model.setCurrenciesRates(currenciesRates);
            return currenciesRates;
        }
    }

    private List<CurrencyRate> provideCurrenciesRates() throws IOException {
        List<CurrencyRate> currenciesRates = new LinkedList<>();
        Map<String, String> relevanceCurrenciesCodes = provideRelevanceCurrenciesCodes();
        Elements newCurrenciesRates = parser.parseMonobankCurrenciesRates();
        String newCurencyCodeA = "";
        String newCurencyCodeB = "";
        boolean isMain = false;
        for (Element newCurrencyRate : newCurrenciesRates) {
            Iterator<Entry<String, String>> iteratorCurrenciesCodes = relevanceCurrenciesCodes.entrySet()
                                                                                              .iterator();
            while (iteratorCurrenciesCodes.hasNext()) {
                Entry<String, String> currencyCode = iteratorCurrenciesCodes.next();
                if (currencyCode.getKey()
                                .equals(newCurrencyRate.select("currencycodea")
                                                       .text())) {
                    newCurencyCodeA = currencyCode.getKey();
                }
                if (currencyCode.getKey()
                                .equals(newCurrencyRate.select("currencycodeb")
                                                       .text())) {
                    newCurencyCodeB = currencyCode.getKey();
                }
            }
            if (newCurrencyRate.select("rateCross")
                               .text()
                               .isEmpty()) {
                isMain = true;
            } else {
                isMain = false;
            }
            currenciesRates.add(CurrencyRate.builder()
                                            .withDate(newCurrencyRate.select("date")
                                                                     .text())
                                            .withCurrencyCodeA(newCurrencyRate.select("currencycodea")
                                                                              .text())
                                            .withLetterCodeA(newCurencyCodeA)
                                            .withCurrencyCodeB(newCurrencyRate.select("currencycodeb")
                                                                              .text())
                                            .withLetterCodeB(newCurencyCodeB)
                                            .withRateBuy(newCurrencyRate.select("ratebuy")
                                                                        .text())
                                            .withRateSell(newCurrencyRate.select("ratesell")
                                                                         .text())
                                            .withRateCross(newCurrencyRate.select("ratecross")
                                                                          .text())
                                            .withIsMain(isMain)
                                            .build());
        }
        return currenciesRates;
    }

    public static class Builder {
        private Validator validator;
        private Parser parser;
        private CRUDFile cRUDFile;
        private Model model;

        private Builder() {
        }

        public Builder withModel(Model model) {
            this.model = model;
            return this;
        }

        public Builder withValidator(Validator validator) {
            this.validator = validator;
            return this;
        }

        public Builder withParser(Parser parser) {
            this.parser = parser;
            return this;
        }

        public Builder withTempFileProvider(CRUDFile cRUDFile) {
            this.cRUDFile = cRUDFile;
            return this;
        }

        public Controller build() {
            return new Controller(this);
        }
    }

}
