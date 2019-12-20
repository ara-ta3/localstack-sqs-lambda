package com.ru.waka

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.SQSEvent

class FooHandler extends RequestHandler[SQSEvent, Unit] {
  override def handleRequest(input: SQSEvent, context: Context): Unit = {
    context.getLogger.log(s"Hello World from Scala Code\n")
  }
}