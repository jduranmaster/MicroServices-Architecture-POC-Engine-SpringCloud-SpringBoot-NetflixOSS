package balancer

import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.Bean

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
class LoadBalancerConfiguration {

  @Bean
  def jacksonScalaModule(): DefaultScalaModule = DefaultScalaModule
}