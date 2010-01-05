package org.sevendigital.scala.api.client.http

import java.net.URI

trait IRestCommand {
	def get(uri : URI) : Response
}