package com.bigbird.shares.pojo.list;

import java.math.BigDecimal;

public class SharesList {
    private Integer id;

    private String symbol;

    private String name;

    private Float trade;

    private Float pricechange;

    private Float changepercent;

    private Float buy;

    private Float sell;

    private Float settlement;

    private Float open;

    private Float high;

    private Float low;

    private BigDecimal volume;

    private BigDecimal amount;

    private String code;

    private String ticktime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getTrade() {
        return trade;
    }

    public void setTrade(Float trade) {
        this.trade = trade;
    }

    public Float getPricechange() {
        return pricechange;
    }

    public void setPricechange(Float pricechange) {
        this.pricechange = pricechange;
    }

    public Float getChangepercent() {
        return changepercent;
    }

    public void setChangepercent(Float changepercent) {
        this.changepercent = changepercent;
    }

    public Float getBuy() {
        return buy;
    }

    public void setBuy(Float buy) {
        this.buy = buy;
    }

    public Float getSell() {
        return sell;
    }

    public void setSell(Float sell) {
        this.sell = sell;
    }

    public Float getSettlement() {
        return settlement;
    }

    public void setSettlement(Float settlement) {
        this.settlement = settlement;
    }

    public Float getOpen() {
        return open;
    }

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTicktime() {
        return ticktime;
    }

    public void setTicktime(String ticktime) {
        this.ticktime = ticktime == null ? null : ticktime.trim();
    }
}