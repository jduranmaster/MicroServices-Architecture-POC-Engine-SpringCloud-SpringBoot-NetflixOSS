package balancer.main

import org.springframework.boot.builder.SpringApplicationBuilder
import balancer.LoadBalancerConfiguration

object LoadBalancer {

  def main(args: Array[String]): Unit = {
    new SpringApplicationBuilder(classOf[LoadBalancerConfiguration]).run(args: _*)
  }

}