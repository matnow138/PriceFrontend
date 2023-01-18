package com.kodilla.prices.external.prices;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodilla.prices.domain.offer.AmazonOffer;
import org.javamoney.moneta.FastMoney;

import java.math.BigDecimal;


public class AmazonOfferDto {

    public AmazonOfferDto() {
    }

    public AmazonOfferDto(String id, String asin, String title, BigDecimal currentPrice, String currency_symbol, BigDecimal targetPrice, String userId) {
        this.id = id;
        this.asin = asin;
        this.title = title;
        this.currentPrice = currentPrice;
        this.currency_symbol = currency_symbol;
        this.targetPrice = targetPrice;
        this.userId = userId;
    }

    @JsonProperty("id")
    private String id;
    @JsonProperty("asin")
    private String asin;
    @JsonProperty("product_name")
    private String title;
    @JsonProperty("current_price")
    private BigDecimal currentPrice;

    @JsonProperty("currency_symbol")
    private String currency_symbol;

    private BigDecimal targetPrice;

    @JsonProperty("userId")
    private String userId;

    public static AmazonOfferDto fromDomain(AmazonOffer amazonOffer) {
        return new AmazonOfferDto(
                amazonOffer.id(),
                amazonOffer.asin(),
                amazonOffer.title(),
                null,

                amazonOffer.targetPrice().getCurrency().getCurrencyCode(),
                BigDecimal.valueOf(amazonOffer.targetPrice().getNumber().doubleValue()),
                amazonOffer.userId()
        );
    }


    public AmazonOffer toDomain() {
        return new AmazonOffer(
                id,
                asin,
                title,
                FastMoney.of(currentPrice, "USD"),
                targetPrice != null ? FastMoney.of(targetPrice, "PLN") : null,
                userId
        );
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public BigDecimal getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(BigDecimal targetPrice) {
        this.targetPrice = targetPrice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
