/**
 * 
 */
package test.com.juxtapose.example.ch04;

import com.juxtapose.example.ch04.stop.StopStepListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * 
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 * 2013-3-20下午10:35:56
 */
public class JobLaunchStopBusiness {
	
	/**
	 * 执行批处理作业.<br>
	 * @param jobPath	作业配置文件
	 * @param jobName	作业名
	 * @param builder	作业参数构造器
	 */
	public static void executeJobAndStop(String jobPath, String jobName, JobParametersBuilder builder) {
		ApplicationContext context = new ClassPathXmlApplicationContext(jobPath);
		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncherAsyn");
		StopStepListener<?> stopListener = (StopStepListener<?>) context.getBean("stopListener");
		Job job = (Job) context.getBean(jobName);
		try {
			launcher.run(job, builder.toJobParameters());
			Thread.sleep(500);
			//通过这种方式可以在业务中进行job的停止操作
			stopListener.setStop(Boolean.TRUE);
			System.err.println("setStop ----------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		executeJobAndStop("ch04/job/job-stop.xml", "chunkBusinessJob",
				new JobParametersBuilder().addDate("date", new Date()));
	}
}
