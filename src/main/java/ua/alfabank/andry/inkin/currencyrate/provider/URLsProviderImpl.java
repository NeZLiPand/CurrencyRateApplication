package ua.alfabank.andry.inkin.currencyrate.provider;

public class URLsProviderImpl implements URLsProvider {

    @Override
    public String urlAPIMonobankCurrencyRates() {
        return "https://api.monobank.ua/bank/currency";
    }
    
    @Override
    public String urlMinfinCurrencyCodes() {
        return "https://index.minfin.com.ua/reference/currency/code/";
    }
}
