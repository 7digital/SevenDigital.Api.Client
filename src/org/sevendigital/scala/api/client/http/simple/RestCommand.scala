package org.sevendigital.scala.api.client.http.simple

import java.net.URI
import org.sevendigital.scala.api.client.http.{Response, IRestCommand}
import org.apache.commons.httpclient.methods.GetMethod
import org.apache.commons.httpclient.{HttpMethodBase, HttpClient}
import org.apache.http.HttpStatus

class RestCommand extends IRestCommand {
	def get(uri : URI) = execute(newGet(uri))

	private def newGet(uri : URI) = new GetMethod(uri toString)

	private def execute(method : HttpMethodBase) : Response = {
		setLogLevel

		val status = new HttpClient() executeMethod(method)

		if (status != HttpStatus.SC_OK)
			return new Response(
				status,
				new java.net.URI(method.getURI.getURI),
				method.getStatusText
			)

		new Response(
			status,
			new java.net.URI(method.getURI.getURI),
			method.getResponseBodyAsString
		)
	}

	private def setLogLevel {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "false");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");	
	}
}
