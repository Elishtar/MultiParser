package org.ak.parser.process;

import org.ak.parser.print.Printer;
import org.ak.parser.reader.CsvReader;
import org.ak.parser.reader.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Andrey Klyuev on 01.11.2020.
 */
@Service
public class Processor {

  @Autowired
  private Printer printer;

  @Autowired
  private CsvReader csvReader;

  @Autowired
  private JsonReader jsonReader;

  public void process(String[] files) {
    printer.setCount(files.length);
    Arrays.asList(files).forEach(path -> {
      switch (path.substring(path.lastIndexOf(".") + 1)) {
        case "json": jsonReader.read(path);
          break;
        case "csv": csvReader.read(path);
          break;
      }
    });
    while (true) {
      if (printer.getCount() == 0) {
        printer.print();
        System.exit(0);
      }
    }
  }

}
