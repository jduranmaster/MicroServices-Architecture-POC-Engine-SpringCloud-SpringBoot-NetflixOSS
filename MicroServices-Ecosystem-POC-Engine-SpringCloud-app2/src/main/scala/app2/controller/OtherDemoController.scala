package app2.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping(Array("/show"))
class OtherDemoController {

  @RequestMapping(value = Array("/{msg}"), method = Array(RequestMethod.GET))
  def show(@PathVariable("msg") s: String) = "concatenated with " + s

}