package com.juxtapose.example.ch06.flat;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.LineCallbackHandler;

import java.io.IOException;
import java.io.Writer;

/**
 * 
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 * 2013-4-3下午08:01:45
 */
public class CopyHeaderLineCallbackHandler implements LineCallbackHandler,
		FlatFileHeaderCallback {
	private static final Logger logger = Logger.getLogger(CopyHeaderLineCallbackHandler.class);
	private String header = "";

	/**
	 * 获取跳过的行的内容
	 *
	 * @param line
	 */
	@Override
	public void handleLine(String line) {
		logger.info("跳过的行--->" + line);
		this.header = line+ "【跳过】";
	}

	/**
	 * 写到文件顶部【内容需要自己控制】
	 *
	 * @param writer
	 * @throws IOException
	 */
	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write(header);
	}
}
