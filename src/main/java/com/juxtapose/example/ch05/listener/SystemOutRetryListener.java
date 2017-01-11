/**
 * 
 */
package com.juxtapose.example.ch05.listener;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 * 2013-3-24下午08:26:10
 */
public class SystemOutRetryListener implements RetryListener {
	@Override
	public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
		System.out.println("SystemOutRetryListener RetryListener open()");

		//return false; org.springframework.retry.TerminatedRetryException: Retry terminated abnormally by interceptor before first attempt
		return true;
	}

	@Override
	public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
		System.out.println("SystemOutRetryListener RetryListener close()");
	}

	@Override
	public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
		System.out.println("SystemOutRetryListener RetryListener onError()");
	}
}
