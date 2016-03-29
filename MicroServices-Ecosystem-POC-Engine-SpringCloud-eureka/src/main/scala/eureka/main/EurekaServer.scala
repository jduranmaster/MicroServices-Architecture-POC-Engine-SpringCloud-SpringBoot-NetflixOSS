package eureka.main

import org.springframework.boot.builder.SpringApplicationBuilder
import eureka.EurekaServerConfiguration

object EurekaServer {

  def main(args: Array[String]): Unit = {
    new SpringApplicationBuilder(classOf[EurekaServerConfiguration]).run(args: _*)
  }
}