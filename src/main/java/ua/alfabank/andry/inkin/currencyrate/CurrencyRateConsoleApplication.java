package ua.alfabank.andry.inkin.currencyrate;

import java.io.IOException;

import ua.alfabank.andry.inkin.currencyrate.parser.Parser;
import ua.alfabank.andry.inkin.currencyrate.parser.ParserImpl;
import ua.alfabank.andry.inkin.currencyrate.provider.TempFileProvider;
import ua.alfabank.andry.inkin.currencyrate.provider.TempFileProviderImpl;
import ua.alfabank.andry.inkin.currencyrate.provider.URLsProvider;
import ua.alfabank.andry.inkin.currencyrate.provider.URLsProviderImpl;
import ua.alfabank.andry.inkin.currencyrate.service.RequestHandler;
import ua.alfabank.andry.inkin.currencyrate.validator.Validator;
import ua.alfabank.andry.inkin.currencyrate.validator.ValidatorImpl;

public class CurrencyRateConsoleApplication {

    public static void main(String[] args) throws IOException {
        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl();
        URLsProvider urlsProvider = new URLsProviderImpl();
        TempFileProvider tempFileProvider = new TempFileProviderImpl();
        RequestHandler requestHandler = RequestHandler.builder()
                                                      .withParser(parser)
                                                      .withTempFileProvider(tempFileProvider)
                                                      .withUrlsProvider(urlsProvider)
                                                      .withValidator(validator)
                                                      .build();
        requestHandler.processingRequest();
    }

}
