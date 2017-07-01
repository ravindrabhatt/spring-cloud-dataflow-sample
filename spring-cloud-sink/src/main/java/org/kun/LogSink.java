package org.kun;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.handler.LoggingHandler;

@EnableBinding(Sink.class)
public class LogSink {

  @Bean
  @ServiceActivator(inputChannel = Sink.INPUT)
  public LoggingHandler logSinkHandler() {
    LoggingHandler loggingHandler = new LoggingHandler(LoggingHandler.Level.INFO);
    loggingHandler.setLoggerName("org.kun.LogSink");
    return loggingHandler;
  }

}