/**
 *
 */
package com.juxtapose.example.ch05;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 *         2013-3-19下午08:56:21
 */
public class ConsoleWriter implements ItemWriter<String> {
    private static final Logger logger = Logger.getLogger(ConsoleWriter.class);

    public void write(List<? extends String> items) throws Exception {
        logger.info("Write begin:");
        for (String item : items) {
            logger.info(item + ",");
        }
        logger.info("Write end!!");
    }

}
