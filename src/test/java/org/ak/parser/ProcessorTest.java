package org.ak.parser;

import org.ak.parser.process.Processor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(args = {"src/test/resources/test.csv", "src/test/resources/test.json"})
public class ProcessorTest {

    @Test
    public void testProcessor() {
    }
}