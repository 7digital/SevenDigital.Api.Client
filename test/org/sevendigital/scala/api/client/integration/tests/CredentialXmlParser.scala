package org.sevendigital.scala.api.client.integration.tests


import _root_.scala.xml.{NodeSeq, Elem, XML}
import org.coriander.oauth.core.{Credential, CredentialSet}

class CredentialXmlParser {
	def parse(file : String) : CredentialSet = parse(load(file))

	def parse(xml : Elem) : CredentialSet = {
		return new CredentialSet(
			parseConsumer(xml),
			parseToken(xml)
		)
	}

	private def parseConsumer(xml : Elem) = parse(xml\"consumer")
	                                     
	private def parseToken(xml : Elem) = parse(xml\"token")

	private def parse(nodes : NodeSeq) : Credential = {
		return if (nodes.isEmpty) null else
			new Credential(
				nodes.first.attribute("key").get.first.text,
				nodes.first.attribute("secret").get.first.text
			)
	}

	private def load(file : String) = XML loadFile file
}