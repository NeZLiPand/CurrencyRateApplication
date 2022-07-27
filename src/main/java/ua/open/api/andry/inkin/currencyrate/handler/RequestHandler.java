package ua.open.api.andry.inkin.currencyrate.handler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.nodes.Document;

import ua.open.api.andry.inkin.currencyrate.domain.MainCurrencyRate;
import ua.open.api.andry.inkin.currencyrate.domain.MinorCurrencyRate;
import ua.open.api.andry.inkin.currencyrate.parse.Parser;
import ua.open.api.andry.inkin.currencyrate.provider.CRUDFile;
import ua.open.api.andry.inkin.currencyrate.validator.Validator;

public class RequestHandler {
    private Validator validator;
    private Parser parser;
    private CRUDFile cRUDFile;

    public RequestHandler(Builder builder) {
        this.validator = builder.validator;
        this.parser = builder.parser;
        this.cRUDFile = builder.cRUDFile;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void processingRequest() throws IOException {
        MainCurrencyRate mainCurrencyRate = new MainCurrencyRate();
        MinorCurrencyRate minorCurrencyRate = new MinorCurrencyRate();
        List<MinorCurrencyRate> minorCurrenciesRate = new LinkedList<>();
        List<MainCurrencyRate> mainCurrenciesRate = new LinkedList<>();

        validator.validate();

        parser.parseMonobankCurrencyRates();
        parser.parseMinfinCurrencyCodes();
//        Document documentCurrencyCodes = parser.parseMinfinCurrencyCodes();
//        System.out.println(documentCurrencyCodes);

//        MyUtilities.dateConverterFromUNIXTimeToISO8601(System.currentTimeMillis() / 1000);

//        for (int iterator = 0; iterator < currencyRateArray.size(); iterator++) {
//            if (currencyRateArray.get(iterator)
//                                 .childNodeSize() == mainCurrencyRate.getColumnCount()) {
//                mainCurrenciesRate.add(MainCurrencyRate.builder()
//                                                       .withDate(currencyRateArray.get(iterator)
//                                                                                  .select("date")
//                                                                                  .text())
//                                                       .withCurrencyCodeA(currencyRateArray.get(iterator)
//                                                                                           .select("currencycodea")
//                                                                                           .text())
//                                                       .withCurrencyCodeB(currencyRateArray.get(iterator)
//                                                                                           .select("currencycodeb")
//                                                                                           .text())
//                                                       .withRateBuy(currencyRateArray.get(iterator)
//                                                                                     .select("ratebuy")
//                                                                                     .text())
//                                                       .withRateSell(currencyRateArray.get(iterator)
//                                                                                      .select("ratesell")
//                                                                                      .text())
//                                                       .build());
//            } else if (currencyRateArray.get(iterator)
//                                        .childNodeSize() == minorCurrencyRate.getColumnCount()) {
//                minorCurrenciesRate.add(MinorCurrencyRate.builder()
//                                                         .withDate(currencyRateArray.get(iterator)
//                                                                                    .select("date")
//                                                                                    .text())
//                                                         .withCurrencyCodeA(currencyRateArray.get(iterator)
//                                                                                             .select("currencycodea")
//                                                                                             .text())
//                                                         .withCurrencyCodeB(currencyRateArray.get(iterator)
//                                                                                             .select("date")
//                                                                                             .first()
//                                                                                             .childNode(iterator)
//                                                                                             .toString())
//                                                         .withRateCross(currencyRateArray.get(iterator)
//                                                                                         .select("ratecross")
//                                                                                         .text())
//                                                         .build());
//            } else {
//                // something..
//            }
//        }
    }

    private void parseCurrencyRates(String parsedPage) {
        Document doc = new Document(parsedPage);
        System.out.println(doc.toString());
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
