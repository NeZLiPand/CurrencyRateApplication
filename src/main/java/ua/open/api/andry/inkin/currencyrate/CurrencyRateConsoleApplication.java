package ua.open.api.andry.inkin.currencyrate;

import java.io.IOException;

import ua.open.api.andry.inkin.currencyrate.controller.Controller;
import ua.open.api.andry.inkin.currencyrate.controller.parser.Parser;
import ua.open.api.andry.inkin.currencyrate.controller.parser.ParserImpl;
import ua.open.api.andry.inkin.currencyrate.controller.validator.Validator;
import ua.open.api.andry.inkin.currencyrate.controller.validator.ValidatorImpl;
import ua.open.api.andry.inkin.currencyrate.controller.workingwithfiles.CRUDFile;
import ua.open.api.andry.inkin.currencyrate.controller.workingwithfiles.CRUDFileImpl;
import ua.open.api.andry.inkin.currencyrate.model.Model;
import ua.open.api.andry.inkin.currencyrate.view.ViewProvider;

public class CurrencyRateConsoleApplication {

//    1. Implement parsing of the incoming SOAP request;
//    2. Implement the behavior of what to do if: - the currency code is specified in the request; - or, if the currency code was not specified;
//    3. Implement the database and work with it according to the Diagram, which is in the "other" folder, which, in turn, is in the root of the project;
//    4. At the end of the application: - be sure to delete all temporary files !!!
//    5. Make normal documentation for the methods.
//      
//      https://www.w3schools.com/xml/xml_soap.asp 
//      Finished creating:
//      "test request" for this API, a file request called "getCurrencyRequest.xml" - get the currency rate. In order to later
//          implement "respond" - a response, according to the plan in tech-tasks.

    public static void main(String[] args) {
        Model model = new Model();
        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl();
        CRUDFile cRUDFile = new CRUDFileImpl();
        Controller controller = Controller.builder()
                                          .withParser(parser)
                                          .withTempFileProvider(cRUDFile)
                                          .withValidator(validator)
                                          .withModel(model)
                                          .build();
        ViewProvider viewProvider = new ViewProvider();
        try {
            viewProvider.provideView(controller.provideRelevanceCurrenciesRates());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
