package org.sevendigital.scala.api.client.integration.tests

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.core.Is._
import org.hamcrest.core.IsNot._
import org.hamcrest.core.IsEqual._
import org.sevendigital.scala.api.client.http.simple.RestCommand
import java.net.URI
import org.apache.http.HttpStatus

class Public {
	@Test
	def I_can_get_rejected_read_the_public_api {
		val url = new URI(
			"http://api.7digital.com/sandbox/1.2/artist/browse?letter=p&country=GB"
		)

		val result = new RestCommand() get(url)
		
		assertThat(result.status, is(equalTo(HttpStatus.SC_UNAUTHORIZED)))
		assertThat(result.responseText, is(equalTo("Unauthorized")))
    }
}