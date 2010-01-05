package org.sevendigital.scala.api.client.http

import java.net.URI

class Response(val status : Int, val responseUri : URI, val responseText : String)

object Response {
	def empty = new Response(-1, null, "This response has not been initialized")
}