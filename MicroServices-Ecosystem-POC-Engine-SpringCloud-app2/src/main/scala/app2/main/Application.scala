package app2.main

import app2.ApplicationConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder

object Application {

  def main(args: Array[String]): Unit = {
    new SpringApplicationBuilder(classOf[ApplicationConfiguration]).run(args: _*)
  }

}