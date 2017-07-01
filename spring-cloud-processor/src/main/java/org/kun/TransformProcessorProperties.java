package org.kun;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@ConfigurationProperties
public class TransformProcessorProperties {

  private static final Expression DEFAULT_EXPRESSION = new SpelExpressionParser().parseExpression("payload");

  private Expression expression = DEFAULT_EXPRESSION;

  public Expression getExpression() {
    return expression;
  }

  public void setExpression(Expression expression) {
    this.expression = expression;
  }

}