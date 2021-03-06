package org.sevendigital.scala.api.client.integration.tests

import java.io.File
import org.coriander.oauth.core.Credential
import org.junit.Assert._

class IntegrationTestFixture {
	protected def given_a_valid_7digital_consumer {
		val file = new File(CREDENTIAL_FILE).getCanonicalFile

		unless (file.exists) {
			fail(
				"Frightfully sorry, but you haven't configured your consumer information. " +
				"Ensure you have the file <" + CREDENTIAL_FILE + "> available, " +
				"and it contains your 7digital API consumer details."
			)
		}

		consumer = new CredentialXmlParser() parse(CREDENTIAL_FILE) consumer
	}

	private lazy val CREDENTIAL_FILE = "test/res/consumer.xml"

	protected var consumer : Credential = null

	protected def unless(what : Boolean)(`do` : => Unit) = if (false == what) {
		`do`
	}
}
