/**
 *
 */
package test.com.juxtapose.example.ch04;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 *         2013-2-28下午08:34:48
 */
public class JobLaunchValidator {

    /**
     * 执行批处理作业.<br>
     *
     * @param jobPath 作业配置文件
     * @param jobName 作业名
     * @param builder 作业参数构造器
     */
    public static void executeJob(String jobPath, String jobName, JobParametersBuilder builder) {
        ApplicationContext context = new ClassPathXmlApplicationContext(jobPath);
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean(jobName);
        try {
            JobExecution result = launcher.run(job, builder.toJobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeJobValidatorOK() {
        executeJob("ch04/job/job-validator.xml", "billJob",
                new JobParametersBuilder().addDate("date", new Date()));
    }

    public static void executeJobValidatorError() {
        executeJob("ch04/job/job-validator.xml", "billJob",
                new JobParametersBuilder().addDate("date", new Date())
                        .addString("test", "test parameter not allowed."));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
		executeJobValidatorOK();
//        org.springframework.batch.core.JobParametersInvalidException: The JobParameters contains keys that are not explicitly optional or required: [test]
//        at org.springframework.batch.core.job.DefaultJobParametersValidator.validate(DefaultJobParametersValidator.java:105)
//        at org.springframework.batch.core.launch.support.SimpleJobLauncher.run(SimpleJobLauncher.java:117)
//        at test.com.juxtapose.example.ch04.JobLaunchValidator.executeJob(JobLaunchValidator.java:33)
//        at test.com.juxtapose.example.ch04.JobLaunchValidator.executeJobValidatorError(JobLaunchValidator.java:46)
//        at test.com.juxtapose.example.ch04.JobLaunchValidator.main(JobLaunchValidator.java:56)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.lang.reflect.Method.invoke(Method.java:498)
//        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:143)
//        executeJobValidatorError();
    }
}
