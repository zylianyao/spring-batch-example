/**
 *
 */
package com.juxtapose.example.ch05;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 *         2013-3-19下午08:54:49
 */
public class AutoReader implements ItemReader<String> {
    private static final Logger logger = Logger.getLogger(com.juxtapose.example.ch04.stop.AutoReader.class);
    private int count = 0;
    private int maxCount = 30;

    public String read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        ++count;
        logger.info(count);
        if (count > maxCount) {
            return null;
        } else {
            return ++count + "";
        }
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

}
