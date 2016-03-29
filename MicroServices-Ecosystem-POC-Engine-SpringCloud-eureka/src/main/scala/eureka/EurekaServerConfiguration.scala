package eureka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.beans.factory.annotation.Value
import javax.annotation.PostConstruct
import org.springframework.context.annotation.Import
import org.springframework.cloud.netflix.archaius.ArchaiusAutoConfiguration
import com.netflix.config.sources.URLConfigurationSource
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Autowired
import com.netflix.discovery.EurekaClientConfig
import com.netflix.config.DynamicStringProperty
import com.netflix.config.DynamicPropertyFactory
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean

@EnableEurekaServer
@EnableDiscoveryClient
@SpringBootApplication
@Import(Array(classOf[ArchaiusAutoConfiguration]))
class EurekaServerConfiguration {

  @Autowired
  var clientConfig: EurekaClientConfigBean = null

  @PostConstruct
  def attachProperties(): Unit = {

    val property = DynamicPropertyFactory.getInstance().getStringProperty("eureka.instance.client.serviceUrl.defaultZone", "")
    property.addCallback(PropertyCallback(property))

  }

  case class PropertyCallback(property: DynamicStringProperty) extends Runnable {
    def run(): Unit = {
      clientConfig.getServiceUrl.put(EurekaClientConfigBean.DEFAULT_ZONE, property.get)
    }
  }
}

