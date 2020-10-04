package hello.core.logdemo;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import hello.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	private final ObjectProvider<MyLogger> myLoggerProvider;

	public void logic(String id) {
		MyLogger myLogger = myLoggerProvider.getObject();
		myLogger.log("service id = " + id);
	}
}
