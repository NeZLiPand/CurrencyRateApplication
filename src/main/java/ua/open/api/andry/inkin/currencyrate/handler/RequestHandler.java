package ua.open.api.andry.inkin.currencyrate.handler;

import java.io.IOException;

import ua.open.api.andry.inkin.currencyrate.parse.Parser;
import ua.open.api.andry.inkin.currencyrate.provider.TempFileProvider;
import ua.open.api.andry.inkin.currencyrate.utility.MyUtilities;
import ua.open.api.andry.inkin.currencyrate.validator.Validator;

public class RequestHandler {
    private Validator validator;
    private Parser parser;
    private TempFileProvider tempFileProvider;

    public RequestHandler(Builder builder) {
        this.validator = builder.validator;
        this.parser = builder.parser;
        this.tempFileProvider = builder.tempFileProvider;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void processingRequest() throws IOException {
        validator.validate();
//        parser.parseMonobankCurrencyRates();
//        parser.parseMinfinCurrencyCodes();
//        MyUtilities.dateConverterFromUNIXTimeToISO8601(System.currentTimeMillis() / 1000);

//        MainCurrencyRate mainCurrencyRate = new MainCurrencyRate();
//        MinorCurrencyRate minorCurrencyRate = new MinorCurrencyRate();
//        List<MinorCurrencyRate> minorCurrenciesRate = new LinkedList<>();
//        List<MainCurrencyRate> mainCurrenciesRate = new LinkedList<>();
//        List currenciesRate = new LinkedList<>();
//        for (int iterator = 0; iterator < currencyRateArray.size(); iterator++) {
//            if (currencyRateArray.get(iterator)
//                                 .childNodeSize() == mainCurrencyRate.getColumnCount()) {
//                mainCurrenciesRate.add(MainCurrencyRate.builder()
//                                                       .withDate(currencyRateArray.get(i)
//                                                                                  .select("date")
//                                                                                  .text())
//                                                       .withCurrencyCodeA(currencyRateArray.get(i)
//                                                                                           .select("currencycodea")
//                                                                                           .text())
//                                                       .withCurrencyCodeB(currencyRateArray.get(i)
//                                                                                           .select("currencycodeb")
//                                                                                           .text())
//                                                       .withRateBuy(currencyRateArray.get(i)
//                                                                                     .select("ratebuy")
//                                                                                     .text())
//                                                       .withRateSell(currencyRateArray.get(i)
//                                                                                      .select("ratesell")
//                                                                                      .text())
//                                                       .build());
//            } else if (currencyRateArray.get(iterator)
//                                     .childNodeSize() == minorCurrencyRate.getColumnCount()) {
//                    minorCurrenciesRate.add(MinorCurrencyRate.builder()
//                                                             .withDate(currencyRateArray.get(i)
//                                                                                        .select("date")
//                                                                                        .text())
//                                                             .withCurrencyCodeA(currencyRateArray.get(i)
//                                                                                                 .select("currencycodea")
//                                                                                                 .text())
//                                                             .withCurrencyCodeB(currencyRateArray.get(i)
//                                                                                                 .select("date")
//                                                                                                 .first()
//                                                                                                 .childNode(i)
//                                                                                                 .toString())
//                                                             .withRateCross(currencyRateArray.get(i)
//                                                                                             .select("ratecross")
//                                                                                             .text())
//                                                             .build());
//            } else {
////                  something..
//            }
//        }
    }

    public static class Builder {
        private Validator validator;
        private Parser parser;
        private TempFileProvider tempFileProvider;

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

        public Builder withTempFileProvider(TempFileProvider tempFileProvider) {
            this.tempFileProvider = tempFileProvider;
            return this;
        }

        public RequestHandler build() {
            return new RequestHandler(this);
        }
    }

}
