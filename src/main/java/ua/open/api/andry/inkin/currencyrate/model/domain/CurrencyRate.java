package ua.open.api.andry.inkin.currencyrate.model.domain;

import java.util.Objects;

//Зробити нормальну документацію к методам
public class CurrencyRate {
//    Код валюти рахунку відповідно ISO 4217
    private String currencyCodeA;
    private String letterCodeA;
//    Код валюти рахунку відповідно ISO 4217
    private String currencyCodeB;
    private String letterCodeB;
//    Час курсу в секундах в форматі Unix time
    private String date;
//    Курс продажі
    private String rateSell;
//    Курс купівлі  
    private String rateBuy;
//    Курс обміну  
    private String rateCross;
//    Курс обміну  
    private boolean isMain;

    private CurrencyRate(Builder builder) {
        this.currencyCodeA = builder.currencyCodeA;
        this.letterCodeA = builder.letterCodeA;
        this.letterCodeB = builder.letterCodeB;
        this.currencyCodeB = builder.currencyCodeB;
        this.date = builder.date;
        this.rateSell = builder.rateSell;
        this.rateBuy = builder.rateBuy;
        this.rateCross = builder.rateCross;
        this.isMain = builder.isMain;
    }

    public CurrencyRate() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

    public String getLetterCodeB() {
        return letterCodeB;
    }

    public String getLetterCodeA() {
        return letterCodeA;
    }

    public String getCurrencyCodeA() {
        return currencyCodeA;
    }

    public String getRateCross() {
        return rateCross;
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

    public boolean getIsMain() {
        return isMain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCodeA, currencyCodeB, date, isMain, letterCodeA, letterCodeB, rateBuy, rateCross, rateSell);
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
        CurrencyRate other = (CurrencyRate) obj;
        return Objects.equals(currencyCodeA, other.currencyCodeA) &&
               Objects.equals(currencyCodeB, other.currencyCodeB) &&
               Objects.equals(date, other.date) &&
               isMain == other.isMain &&
               Objects.equals(letterCodeA, other.letterCodeA) &&
               Objects.equals(letterCodeB, other.letterCodeB) &&
               Objects.equals(rateBuy, other.rateBuy) &&
               Objects.equals(rateCross, other.rateCross) &&
               Objects.equals(rateSell, other.rateSell);
    }

    @Override
    public String toString() {
        return "CurrencyRate [currencyCodeA="
               + currencyCodeA
               + ", letterCodeA="
               + letterCodeA
               + ", currencyCodeB="
               + currencyCodeB
               + ", letterCodeB="
               + letterCodeB
               + ", date="
               + date
               + ", rateSell="
               + rateSell
               + ", rateBuy="
               + rateBuy
               + ", rateCross="
               + rateCross
               + ", isMain="
               + isMain
               + "]";
    }

    public static class Builder {
        private String currencyCodeA;
        private String currencyCodeB;
        private String date;
        private String rateSell;
        private String rateBuy;
        private String rateCross;
        private String letterCodeA;
        private String letterCodeB;
        private boolean isMain;

        private Builder() {
        }

        public Builder withIsMain(boolean isMain) {
            this.isMain = isMain;
            return this;
        }

        public Builder withLetterCodeB(String letterCodeB) {
            this.letterCodeB = letterCodeB;
            return this;
        }

        public Builder withLetterCodeA(String letterCodeA) {
            this.letterCodeA = letterCodeA;
            return this;
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

        public Builder withRateCross(String rateCross) {
            this.rateCross = rateCross;
            return this;
        }

        public CurrencyRate build() {
            return new CurrencyRate(this);
        }
    }

}
