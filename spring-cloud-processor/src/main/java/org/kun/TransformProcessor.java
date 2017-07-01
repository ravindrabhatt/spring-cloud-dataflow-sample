package org.kun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.SpelExpressionConverterConfiguration;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Import;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

@EnableBinding(Processor.class)
@Import(SpelExpressionConverterConfiguration.class)
@EnableConfigurationProperties(TransformProcessorProperties.class)
public class TransformProcessor {

  @Autowired
  private TransformProcessorProperties properties;

  @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
  public Object transform(Message<?> message) {
    return properties.getExpression().getValue(message);
  }

}