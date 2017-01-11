package com.juxtapose.example.ch05.policy;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.repeat.policy.DefaultResultCompletionPolicy;

import java.io.IOException;

/**
 * <p></p>
 *
 * @author Zach.zhang
 * @version 1.0
 * @date 2017-01-11
 * @copyright Copyright 2017 BeiJing MMEDNET. All rights reserved.
 * @since JDK 1.7
 */
public class CustCompletionPolicy extends DefaultResultCompletionPolicy {
    private static final Logger logger = Logger.getLogger(CustCompletionPolicy.class);

    @Override
    public boolean isComplete(RepeatContext context, RepeatStatus result) {
        ObjectMapper mapper = new ObjectMapper();
        String Json = null;
        try {
            Json = mapper.writeValueAsString(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("context ---> " + Json);
        logger.info("result ---> " + result);
        return super.isComplete(context, result);
    }

    @Override
    public boolean isComplete(RepeatContext context) {
        ObjectMapper mapper = new ObjectMapper();
        String Json = null;
        try {
            Json = mapper.writeValueAsString(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("context ---> " + Json);
        return super.isComplete(context);
    }

    @Override
    public RepeatContext start(RepeatContext context) {
        ObjectMapper mapper = new ObjectMapper();
        String Json = null;
        try {
            Json = mapper.writeValueAsString(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("context ---> " + Json);

        return super.start(context);
    }

    @Override
    public void update(RepeatContext context) {
        ObjectMapper mapper = new ObjectMapper();
        String Json = null;
        try {
            Json = mapper.writeValueAsString(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("context ---> " + Json);
        super.update(context);
    }
}
