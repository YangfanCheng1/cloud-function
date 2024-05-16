# cloud-function
A template for running Spring based application on AWS Lambda. It supports following three function definitions:
* `Function<I, O>`
* `Consumer<I>`
* `Supplier<O>`

If more than one function is defined in code, we can choose which one to use from properties `function.name`

Depending on the cloud platform, we can choose from the following dependencies:
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-function-adapter-azure</artifactId>
</dependency>

<!-- or -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-function-adapter-gcp</artifactId>
</dependency>

<!-- or --> 
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-function-adapter-aws</artifactId>
</dependency>
```
We can package our artifact using `mvn clean package` or `./mvnw clean package` and reference the output jar.

This project is using AWS, so the configuration looks like below using [Serverless](https://www.serverless.com/) framework.
```yaml
service: sls-aws-spring-cloud-function
provider:
  name: aws
  runtime: java17
  timeout: 10
package:
  artifact: target/cloud-function-0.0.1-SNAPSHOT-aws.jar
functions:
  members:
    handler: org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest
    environment:
      FUNCTION_NAME: yangfan-cloud-function
```
Note that above we can provision AWS resources using Infrastructure as Code, we can also do so manually. 