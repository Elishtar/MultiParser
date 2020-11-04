package org.ak.parser.reader;

import org.ak.parser.model.Order;
import org.ak.parser.print.Printer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Andrey Klyuev on 01.11.2020.
 */
@Service
public class JsonReader {

  @Autowired
  private Printer printer;

  @Async("threadPoolTaskExecutor")
  public void read(String path) {
    StringBuilder json = new StringBuilder();
    String line;
    JSONParser parser = new JSONParser();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      while ((line = br.readLine()) != null) {
        json.append(line);
      }
      final JSONArray array = (JSONArray) parser.parse(json.toString());
      array.forEach(objetc -> {
        JSONObject order = (JSONObject) objetc;
                printer.addOrder(new Order(Long.parseLong(order.get("orderId").toString()),
                Integer.parseInt((String) order.get("amount").toString()),
                order.get("currency").toString(),
                order.get("comment").toString()));
      });
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    } finally {
      printer.decrementAndGet();
    }
  }
}
