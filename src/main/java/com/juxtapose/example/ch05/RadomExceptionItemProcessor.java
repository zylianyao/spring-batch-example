/**
 * 
 */
package com.juxtapose.example.ch05;

import org.springframework.batch.item.ItemProcessor;

import java.util.Random;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 * 2013-3-22下午04:50:05
 */
public class RadomExceptionItemProcessor implements ItemProcessor<String, String> {
	Random ra = new Random();
	
	public String process(String item) throws Exception {
		Thread t = Thread.currentThread();
		String name = t.getName();
		int i = ra.nextInt(10);
		System.out.println("线程---->" + name + " Process " + item + "; Random i=" + i);
		if(i%2 == 0){
			throw new RuntimeException("make error!");
		}else{
			return item;
		}
	}
}
