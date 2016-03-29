package app1.main

import org.springframework.boot.builder.SpringApplicationBuilder
import app1.ApplicationConfiguration

object Application {

  def main(args: Array[String]): Unit = {
    new SpringApplicationBuilder(classOf[ApplicationConfiguration]).run(args: _*)
  }

}