package org.sevendigital.scala.api.client.http

import java.net.URI

trait ITheInternet {
	def get(uri : URI) : Response
}