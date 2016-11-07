package app

import org.jooby.Jooby

/**
 * Extends Jooby
 */
class App : Jooby() {

  /**
   * Configure your application
   */
  init {

    get ("/") { ->
      "Hi Kotlin"
    }

    get ("/:name") { req ->
      "Hi " + req.param("name").value()
    }

    get ("/rsp/:name") { req, rsp ->
      rsp.send("Hi " + req.param("name").value())
    }
  }

}

/**
 * Start Jooby
 */
fun main(args: Array<String>) {
  Jooby.run(::App, args)
}
