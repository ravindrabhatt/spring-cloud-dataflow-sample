package org.kun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@EnableBinding(Source.class)
public class HttpSource {

  @Autowired
  private Source channels;

  @RequestMapping(path = "/kun", method = POST, consumes = {"text/*", "application/json"})
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void handleRequest(@RequestBody String body, @RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) {
    sendMessage(body, contentType);
  }

  private void sendMessage(Object body, Object contentType) {
    channels.output().send(MessageBuilder.createMessage(body,
      new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, contentType))));
  }
}