package org.sevendigital.scala.api.client.core

class Name(val name : String, val sortName : String, val appearsAs : String)  {
	def this(name : String) = this(name, name, name)
}