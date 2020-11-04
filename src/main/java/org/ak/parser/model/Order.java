package org.ak.parser.model;

/**
 * Created by Andrey Klyuev on 01.11.2020.
 */

public class Order {

  private long orderId;
  private int amount;
  private String currency;
  private String comment;

  public Order(long orderId, int amount, String currency, String comment) {
    this.orderId = orderId;
    this.amount = amount;
    this.currency = currency;
    this.comment = comment;
  }

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
