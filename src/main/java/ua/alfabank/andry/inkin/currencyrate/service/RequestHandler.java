package ua.alfabank.andry.inkin.currencyrate.service;

import java.io.IOException;

import ua.alfabank.andry.inkin.currencyrate.parser.Parser;
import ua.alfabank.andry.inkin.currencyrate.provider.TempFileProvider;
import ua.alfabank.andry.inkin.currencyrate.provider.URLsProvider;
import ua.alfabank.andry.inkin.currencyrate.utility.MyUtilities;
import ua.alfabank.andry.inkin.currencyrate.validator.Validator;

public class RequestHandler {
    private Validator validator;
    private Parser parser;
    private URLsProvider urlsProvider;
    private TempFileProvider tempFileProvider;

    public RequestHandler(Builder builder) {
        this.validator = builder.validator;
        this.parser = builder.parser;
        this.urlsProvider = builder.urlsProvider;
        this.tempFileProvider = builder.tempFileProvider;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void processingRequest() throws IOException {
        validator.validate();
        tempFileProvider.provideTempFile("tempBankCurrencyRates", "xml", MyUtilities.convertJSONArraytoXMLArray(parser.parse(urlsProvider.urlAPIMonobankCurrencyRates())));
        
        
        tempFileProvider.deleteFile("tempBankCurrencyRates", "xml");
    }

    public static class Builder {
        private Validator validator;
        private Parser parser;
        private URLsProvider urlsProvider;
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

        public Builder withUrlsProvider(URLsProvider urlsProvider) {
            this.urlsProvider = urlsProvider;
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
