/**
 *
 */
package test.com.juxtapose.example.ch03;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 *         2013-2-28下午08:34:48
 */
public class JobLaunch {

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

    /**
     * @param args
     */
    public static void main(String[] args) {
        //org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException: A job instance already exists and is complete for parameters={date=20130309}.  If you want to run this job again, change the parameters.
        //同参数的job只能成功执行一次多次执行会报上面的错
        executeJob("ch03/job/job.xml", "billJob",
                new JobParametersBuilder().addString("date", "20130309"));
    }
}
