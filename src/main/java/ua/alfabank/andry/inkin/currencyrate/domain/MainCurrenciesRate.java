package ua.alfabank.andry.inkin.currencyrate.domain;

import java.util.Objects;

public class MainCurrenciesRate {
//    Код валюти рахунку відповідно ISO 4217
    private String currencyCodeA;
//    Код валюти рахунку відповідно ISO 4217
    private String currencyCodeB;
//    Час курсу в секундах в форматі Unix time
    private String date;
    private String rateSell;
    private String rateBuy;

    private MainCurrenciesRate(Builder builder) {
        this.currencyCodeA = builder.currencyCodeA;
        this.currencyCodeB = builder.currencyCodeB;
        this.date = builder.date;
        this.rateSell = builder.rateSell;
        this.rateBuy = builder.rateBuy;
    }
    
    public MainCurrenciesRate() {
    }
    
    public static Builder builder() {
        return new Builder();
    }

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

    public String getCurrencyCodeA() {
        return currencyCodeA;
    }

    public String getCurrencyCodeB() {
        return currencyCodeB;
    }

    public String getDate() {
        return date;
    }

    public String getRateSell() {
        return rateSell;
    }

    public String getRateBuy() {
        return rateBuy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCodeA, currencyCodeB, date, rateBuy, rateSell);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MainCurrenciesRate other = (MainCurrenciesRate) obj;
        return Objects.equals(currencyCodeA, other.currencyCodeA) &&
               Objects.equals(currencyCodeB, other.currencyCodeB) &&
               Objects.equals(date, other.date) &&
               Objects.equals(rateBuy, other.rateBuy) &&
               Objects.equals(rateSell, other.rateSell);
    }

    @Override
    public String toString() {
        return "MainCurrenciesRate [currencyCodeA="
               + currencyCodeA
               + ", currencyCodeB="
               + currencyCodeB
               + ", date="
               + date
               + ", rateSell="
               + rateSell
               + ", rateBuy="
               + rateBuy
               + "]";
    }

    public static class Builder {
        private String currencyCodeA;
        private String currencyCodeB;
        private String date;
        private String rateSell;
        private String rateBuy;

        private Builder() {
        }

        public Builder withCurrencyCodeA(String currencyCodeA) {
            this.currencyCodeA = currencyCodeA;
            return this;
        }

        public Builder withCurrencyCodeB(String currencyCodeB) {
            this.currencyCodeB = currencyCodeB;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withRateSell(String rateSell) {
            this.rateSell = rateSell;
            return this;
        }

        public Builder withRateBuy(String rateBuy) {
            this.rateBuy = rateBuy;
            return this;
        }

        public MainCurrenciesRate build() {
            return new MainCurrenciesRate(this);
        }
    }
}
