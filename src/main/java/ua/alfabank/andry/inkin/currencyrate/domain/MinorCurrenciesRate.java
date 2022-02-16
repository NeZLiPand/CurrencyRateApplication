package ua.alfabank.andry.inkin.currencyrate.domain;

import java.util.Objects;

public class MinorCurrenciesRate {
//  Код валюти рахунку відповідно ISO 4217
    private String currencyCodeA;
//  Код валюти рахунку відповідно ISO 4217
    private String currencyCodeB;
//  Час курсу в секундах в форматі Unix time
    private String date;
    private String rateCross;

    private MinorCurrenciesRate(Builder builder) {
        this.currencyCodeA = builder.currencyCodeA;
        this.currencyCodeB = builder.currencyCodeB;
        this.date = builder.date;
        this.rateCross = builder.rateCross;
    }

    public MinorCurrenciesRate() {
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

    public String getRateCross() {
        return rateCross;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCodeA, currencyCodeB, date, rateCross);
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
        MinorCurrenciesRate other = (MinorCurrenciesRate) obj;
        return Objects.equals(currencyCodeA, other.currencyCodeA) &&
               Objects.equals(currencyCodeB, other.currencyCodeB) &&
               Objects.equals(date, other.date) &&
               Objects.equals(rateCross, other.rateCross);
    }

    @Override
    public String toString() {
        return "MinorCurrenciesRate [currencyCodeA="
               + currencyCodeA
               + ", currencyCodeB="
               + currencyCodeB
               + ", date="
               + date
               + ", rateCross="
               + rateCross
               + "]";
    }

    public static class Builder {
        private String currencyCodeA;
        private String currencyCodeB;
        private String date;
        private String rateCross;

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

        public Builder withRateCross(String rateCross) {
            this.rateCross = rateCross;
            return this;
        }

        public MinorCurrenciesRate build() {
            return new MinorCurrenciesRate(this);
        }
    }
}
