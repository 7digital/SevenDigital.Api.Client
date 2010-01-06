package org.sevendigital.scala.api.client.integration.tests

import org.junit.Assert._
import org.hamcrest.core.Is._
import org.hamcrest.core.IsNot._
import org.hamcrest.core.IsEqual._
import org.sevendigital.scala.api.client.http.simple.RestCommand
import java.net.URI
import org.apache.http.HttpStatus
import org.coriander.oauth.core.timestamp.SystemTimestampFactory
import org.coriander.oauth.core.nonce.SystemNonceFactory
import org.coriander.oauth.core.{Options, CredentialSet, SignedUri}
import org.coriander.oauth.core.CredentialSet._
import org.junit.Test

class Public extends IntegrationTest {
	@Test
	def given_a_valid_consumer_then_I_can_access_the_api {
		given_a_valid_7digital_consumer
		
		val signed = sign(BROWSE_ARTIST_A)

		val result = this get signed
		
		assertThat(
			"Expected to receive 200 (OK) with a valid consumer <" + consumer.key + ">.",
			result.status,
			is(equalTo(HttpStatus.SC_OK))
		)
	}

	private def sign(uri : URI) = {
		require(consumer != null, "The consumer has not been set")
		
		new SignedUri(
            uri,
            CredentialSet(forConsumer(consumer), andNoToken),
			new SystemTimestampFactory() newTimestamp,
			new SystemNonceFactory() newNonce,
            Options DEFAULT
        ).value
	}

	private def get(uri : URI) = new RestCommand() get(uri)

	private val BROWSE_ARTIST_A = new URI(
		"http://api.7digital.com/1.2/artist/browse?letter=a&country=GB"
	)
}