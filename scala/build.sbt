scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
    "com.amazonaws" % "aws-lambda-java-core"   % "1.2.0",
    "com.amazonaws" % "aws-lambda-java-events" % "2.2.6",
    "com.amazonaws" % "aws-java-sdk-sqs" % "1.11.692"
)
