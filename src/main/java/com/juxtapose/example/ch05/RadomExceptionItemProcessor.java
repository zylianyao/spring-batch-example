/**
 *
 */
package com.juxtapose.example.ch05;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import java.util.Random;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 *         2013-3-22下午04:50:05
 */
public class RadomExceptionItemProcessor implements ItemProcessor<String, String> {
    private static final Logger logger = Logger.getLogger(RadomExceptionItemProcessor.class);
    Random ra = new Random();

    public String process(String item) throws Exception {
        //获取当前线程的名称，用来验证是否是多线程执行
        Thread t = Thread.currentThread();
        String name = t.getName();
        int i = ra.nextInt(10);
        logger.info("Process " + item + "; Random i=" + i);
        if (i % 2 == 0) {
            throw new RuntimeException("make error!");
        } else {
            return item;
        }
    }
}
