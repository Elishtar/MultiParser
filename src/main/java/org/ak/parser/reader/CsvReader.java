package org.ak.parser.reader;

import org.ak.parser.model.Order;
import org.ak.parser.print.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CsvReader {

    @Autowired
    private Printer printer;

    @Async("threadPoolTaskExecutor")
    public void read(String path) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                final String[] order = line.split(",");
                printer.addOrder(new Order(Long.parseLong(order[0]), Integer.parseInt(order[1]),
                        order[2], order[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printer.decrementAndGet();
        }
    }

}