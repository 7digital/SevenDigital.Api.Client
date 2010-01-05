package org.sevendigital.scala.api.client.unit.tests

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.core.Is._
import org.hamcrest.core.IsNot._
import org.hamcrest.core.IsEqual._

class Smoke {
	@Test
	def example {
         assertThat(1, is(equalTo(1)))
    }
}