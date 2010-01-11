package org.sevendigital.scala.api.client.xml


import _root_.scala.xml.Elem
import java.net.URI
import org.sevendigital.scala.api.client.core.{Name, Artist}

class ArtistAdapter(xml : Elem) {
	def toArtist = {
		require(xml != null, "Unable to convert null reference.")

		val id = Integer.parseInt(xml.attribute("id").get text)

		val name = this toName xml
		
		val image 	= new URI(xml \ "image" text)
		val url 	= new URI(xml \ "url" text)

		new Artist(id, name, image, url)
	}

	private def toName(xml : Elem) = new Name(
		xml \ "name" 		text,
		xml \ "sortName" 	text,
		xml \ "appearsAs" 	text
	)
}