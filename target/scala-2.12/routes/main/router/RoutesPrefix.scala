// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/HABQAR/Desktop/dlp-test/conf/routes
// @DATE:Thu Oct 24 10:33:28 CEST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
