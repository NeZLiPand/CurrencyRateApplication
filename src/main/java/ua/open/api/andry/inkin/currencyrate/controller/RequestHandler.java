package ua.open.api.andry.inkin.currencyrate.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ua.open.api.andry.inkin.currencyrate.controller.parser.Parser;
import ua.open.api.andry.inkin.currencyrate.controller.utility.CRUDFile;
import ua.open.api.andry.inkin.currencyrate.controller.utility.MyUtilities;
import ua.open.api.andry.inkin.currencyrate.controller.validator.Validator;
import ua.open.api.andry.inkin.currencyrate.model.domain.MainCurrencyRate;

public class RequestHandler {
    private Validator validator;
    private Parser parser;
    private CRUDFile crudFile;

    public RequestHandler(Builder builder) {
        this.validator = builder.validator;
        this.parser = builder.parser;
        this.crudFile = builder.cRUDFile;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void processingRequest() throws IOException {
//      Додати в валідатор перевірку щось типу: currencyRate.children().size() == new MainCurrencyRate().getColumnCount()
        validator.validate();
        List<MainCurrencyRate> mainCurrenciesRates = new LinkedList<>();
        Elements currencyCodes = Jsoup.parse(parser.parseMinfinCurrencyCodes())
                                      .body()
                                      .children();
        Elements currencyRates = Jsoup.parse(parser.parseMonobankCurrencyRates())
                                      .body()
                                      .children();
        Element currencyRate = new Element("null");
        Element curencyCodeA = new Element("null");
        Element curencyCodeB = new Element("null");
        Element curencyCode = new Element("null");
        for (int iterator = 0; iterator < currencyRates.size(); iterator++) {
            currencyRate = currencyRates.get(iterator);
            for (int iteratorCodes = 0; iteratorCodes < currencyCodes.size(); iteratorCodes++) {
                curencyCode = currencyCodes.get(iteratorCodes);
                if (curencyCode.select("Code")
                               .text()
                               .equals(currencyRate.select("currencycodea")
                                                   .text())) {
                    curencyCodeA = curencyCode;
                }
                if (curencyCode.select("Code")
                               .text()
                               .equals(currencyRate.select("currencycodeb")
                                                   .text())) {
                    curencyCodeB = curencyCode;
                }
            }
            mainCurrenciesRates.add(MainCurrencyRate.builder()
                                                    .withDate(MyUtilities.dateConverterFromUNIXTimeToISO8601(Integer.parseInt(currencyRate.select("date")
                                                                                                                                          .text())))
                                                    .withCurrencyCodeA(currencyRate.select("currencycodea")
                                                                                   .text())
                                                    .withLetterCodeA(curencyCodeA.select("letters")
                                                                                 .text())
                                                    .withCurrencyCodeB(currencyRate.select("currencycodeb")
                                                                                   .text())
                                                    .withLetterCodeB(curencyCodeB.select("letters")
                                                                                 .text())
                                                    .withRateBuy(currencyRate.select("ratebuy")
                                                                             .text())
                                                    .withRateSell(currencyRate.select("ratesell")
                                                                              .text())
                                                    .withRateCross(currencyRate.select("ratecross")
                                                                               .text())
                                                    .build());
        }
//        for (int i = 0; i < mainCurrenciesRates.size(); i++) {
//            mainCurrenciesRates.get(i);
//            System.out.println(mainCurrenciesRates.get(i));
//        }
    }

    public static class Builder {
        private Validator validator;
        private Parser parser;
        private CRUDFile cRUDFile;

        private Builder() {
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

        public RequestHandler build() {
            return new RequestHandler(this);
        }
    }

}
