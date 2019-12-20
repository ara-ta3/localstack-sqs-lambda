package com.ru.waka

import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import com.amazonaws.services.sqs.model.SendMessageRequest

object SQSMessageSender {
  def main(args: Array[String]): Unit = {
    val sqs = AmazonSQSClientBuilder
      .standard()
      .withRegion(Regions.AP_NORTHEAST_1)
      .build()
    val req = new SendMessageRequest()
        .withQueueUrl("http://localhost:4576/queue/foo-queue")
        .withMessageBody("Message from Scala Code")
    sqs.sendMessage(req)
  }
}
