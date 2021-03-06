/**
 * 
 */
package com.juxtapose.example.ch05.step.listener;

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
		return false;
	}

	@Override
	public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {

	}

	@Override
	public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {

	}

//	/* (non-Javadoc)
//	 * @see org.springframework.retry.RetryListener#open(org.springframework.retry.RetryContext, org.springframework.retry.RetryCallback)
//	 */
//	public <T> boolean open(RetryContext context, RetryCallback<T> callback) {
//		System.out.println("RetryListener.open()");
//		return true;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.retry.RetryListener#close(org.springframework.retry.RetryContext, org.springframework.retry.RetryCallback, java.lang.Throwable)
//	 */
//	public <T> void close(RetryContext context, RetryCallback<T> callback,
//			Throwable throwable) {
//		System.out.println("RetryListener.close()");
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.retry.RetryListener#onError(org.springframework.retry.RetryContext, org.springframework.retry.RetryCallback, java.lang.Throwable)
//	 */
//	public <T> void onError(RetryContext context, RetryCallback<T> callback,
//			Throwable throwable) {
//		System.out.println("RetryListener.onError()");
//	}

}
