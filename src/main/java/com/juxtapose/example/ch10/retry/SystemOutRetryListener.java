/**
 * 
 */
package com.juxtapose.example.ch10.retry;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

/**
 * 
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 * 2013-10-21下午10:10:26
 */
public class SystemOutRetryListener implements RetryListener {

	@Override
	public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
		System.out.println("SystemOutRetryListener.open()");
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
