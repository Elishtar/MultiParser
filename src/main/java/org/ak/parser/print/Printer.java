package org.ak.parser.print;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.ak.parser.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Andrey Klyuev on 01.11.2020.
 */
@Component
public class Printer {

  private AtomicInteger count = new AtomicInteger();

  private List<Order> orders = new ArrayList<>();

  public void addOrder(Order order) {
    orders.add(order);
  }

  public void print() {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    try {
      String json = ow.writeValueAsString(orders);
      System.out.println(json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  public int getCount() {
    return count.get();
  }

  public int decrementAndGet() {
    return count.decrementAndGet();
  }

  public void setCount(int count) {
    this.count.set(count);
  }
}
