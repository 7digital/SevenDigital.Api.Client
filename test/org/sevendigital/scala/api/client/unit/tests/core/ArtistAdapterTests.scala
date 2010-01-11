package org.sevendigital.scala.api.client.unit.tests.core

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.core.Is._
import org.hamcrest.core.IsNot._
import org.hamcrest.core.IsEqual._
import org.sevendigital.scala.api.client.xml.ArtistAdapter

class ArtistAdapterTests {
	@Test
	def example { 
    	val actual = new ArtistAdapter(AN_EXAMPLE_ARTIST).toArtist
		
		assertThat("Unexpected id.", actual.id, is(equalTo(14)))
		assertThat("Unexpected name.", actual.name.name, is(equalTo("The Charlatans")))
		assertThat("Unexpected sort name.", actual.name.sortName, is(equalTo("Charlatans, The")))
		assertThat("Unexpected appearsAs", actual.name.appearsAs, is(equalTo("The Charlatans")))
		assertThat("Unexpected image.", actual.image.toString, is(equalTo("http://cdn.7static.com/static/img/artistimages/00/000/000/0000000014_50.jpg")))
		assertThat("Unexpected url.", actual.url.toString, is(equalTo("http://www.7digital.com/artists/the-charlatans/?partner=123")))
    }

	@Test { val expected = classOf[IllegalArgumentException] }
	def toArtist_throws_exception_if_no_xml_element_has_been_supplied {
		 new ArtistAdapter(null).toArtist
	}

	val AN_EXAMPLE_ARTIST =
		<artist id="14">
        	<name>The Charlatans</name>
        	<sortName>Charlatans, The</sortName>
        	<appearsAs>The Charlatans</appearsAs>
        	<image>http://cdn.7static.com/static/img/artistimages/00/000/000/0000000014_50.jpg</image>
        	<url>http://www.7digital.com/artists/the-charlatans/?partner=123</url>
		</artist>
}