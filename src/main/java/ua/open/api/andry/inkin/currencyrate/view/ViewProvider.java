package ua.open.api.andry.inkin.currencyrate.view;

import java.util.List;

import ua.open.api.andry.inkin.currencyrate.model.domain.CurrencyRate;

public class ViewProvider {

    public void provideView(List<CurrencyRate> currenciesRates) {
        for (int iterator = 0; iterator < currenciesRates.size(); iterator++) {
            System.out.println(currenciesRates.get(iterator));
        }
    }

}
