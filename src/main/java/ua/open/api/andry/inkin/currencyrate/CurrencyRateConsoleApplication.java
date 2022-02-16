package ua.open.api.andry.inkin.currencyrate;

import java.io.IOException;

import ua.open.api.andry.inkin.currencyrate.handler.RequestHandler;
import ua.open.api.andry.inkin.currencyrate.parse.Parser;
import ua.open.api.andry.inkin.currencyrate.parse.ParserImpl;
import ua.open.api.andry.inkin.currencyrate.provider.TempFileProvider;
import ua.open.api.andry.inkin.currencyrate.provider.TempFileProviderImpl;
import ua.open.api.andry.inkin.currencyrate.validator.Validator;
import ua.open.api.andry.inkin.currencyrate.validator.ValidatorImpl;

public class CurrencyRateConsoleApplication {
    
    /*
     * 1. Реалізувати парсинг прийшовшого SOAP запиту; 
     * 2. Реалізувати поведінку, що
     * робити, якщо: 
     * - в запиті вказано код валюти; 
     * - або, якщо код валюти не був
     * вказан; 
     * 3. Реалізувати БД та роботу з нею згідно Діаграмі, яка в папці "other", яка в свою чергу в корні проекту; 
     * 4. В кінці роботи додатка: 
     * - обов'язково видалити усі тимчасові файли !!!
     * 
     * https://www.w3schools.com/xml/xml_soap.asp
     * Закінчив на створенні "тестовий запит" для цього API, запит файлом під назвою "getCurrencyRequest.xml" - отримати курс валюти.
     * Для того щоб потім реалізувати "respond" - відповідь, згідно з завданням.
     */
    
    public static void main(String[] args) throws IOException {
        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl();
        TempFileProvider tempFileProvider = new TempFileProviderImpl();
        RequestHandler requestHandler = RequestHandler.builder()
                                                      .withParser(parser)
                                                      .withTempFileProvider(tempFileProvider)
                                                      .withValidator(validator)
                                                      .build();
        requestHandler.processingRequest();
    }

}
