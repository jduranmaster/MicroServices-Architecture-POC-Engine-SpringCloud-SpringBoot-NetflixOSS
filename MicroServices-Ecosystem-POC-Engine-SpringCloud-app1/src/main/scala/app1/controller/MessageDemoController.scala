package app1.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod

@RestController
@RequestMapping(Array("/demo"))
class MessageDemoController {

  @RequestMapping(method = Array(RequestMethod.GET))
  def showMessage() = "demo messsage"

}