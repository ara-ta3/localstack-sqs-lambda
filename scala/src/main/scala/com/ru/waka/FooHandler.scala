package com.ru.waka

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.SQSEvent
import scala.collection.JavaConverters._

class FooHandler extends RequestHandler[SQSEvent, Unit] {
  override def handleRequest(input: SQSEvent, context: Context): Unit = {
    context.getLogger.log("Hello World from Scala Code\n")
    context.getLogger.log("Message's body is...\n")
    input.getRecords.asScala.foreach(r => {
      context.getLogger.log(s"${r.getBody}")
    })
  }
}