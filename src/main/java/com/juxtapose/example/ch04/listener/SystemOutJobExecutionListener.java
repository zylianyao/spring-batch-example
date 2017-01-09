/**
 *
 */
package com.juxtapose.example.ch04.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * 拦截器
 *
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 *         2013-3-9下午08:46:28
 */
public class SystemOutJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("JobExecution creat time:" + jobExecution.getCreateTime());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Job execute state:" + jobExecution.getStatus().toString());
    }
}
