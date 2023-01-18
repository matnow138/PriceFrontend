package com.kodilla.prices.view;

import com.kodilla.prices.domain.offer.AmazonOffer;
import org.javamoney.moneta.FastMoney;

import javax.money.CurrencyUnit;

public class AmazonOfferDto {

    private String id;
    private String asin;
    private Double targetPrice;
    private CurrencyUnit targetCurrency;
    private String userId;

    public AmazonOfferDto(String id, String asin, Double targetPrice, CurrencyUnit targetCurrency, String userId) {
        this.id = id;
        this.asin = asin;
        this.targetPrice = targetPrice;
        this.targetCurrency = targetCurrency;
        this.userId = userId;
    }

    public AmazonOfferDto() {
    }

    public AmazonOfferDto(AmazonOffer amazonOffer) {
        this(amazonOffer.id(), amazonOffer.asin(), amazonOffer.targetPrice().getNumber().doubleValue(), amazonOffer.targetPrice().getCurrency(), amazonOffer.userId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public Double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(Double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public CurrencyUnit getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(CurrencyUnit targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AmazonOffer toDomain() {
        return new AmazonOffer(
                id,
                asin,
                null,
                null,
                FastMoney.of(targetPrice, targetCurrency.getCurrencyCode()),
                userId
        );
    }

}
