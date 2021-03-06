/*
 * Copyright 2017-2019 Lenses.io Ltd
 */
package io.lenses.alerting.plugin.scalaapi

import io.lenses.alerting.plugin.javaapi.{AlertingPlugin => JAlertingPlugin}
import io.lenses.alerting.plugin.scalaapi.util.TryUtils._

import scala.jdk.CollectionConverters._
import scala.util.Try

/**
  * simple alerting plugin wrapper
  */
class AlertingPlugin(underlying: JAlertingPlugin) {

  def init(config: Map[String, String]): Try[AlertingService] = for {
    init <- Try {
      underlying.init(config.asJava)
    }
    service <- init.asScala
  } yield new AlertingService(service)

  def name: String = underlying.name()

  def description: String = underlying.description()

  def configKeys: Seq[ConfigEntry] = underlying.configKeys().asScala.map { c => ConfigEntry(c.getKey, c.getDescription) }.toList
}

object AlertingPlugin {
  def apply(underlying: JAlertingPlugin): AlertingPlugin = new AlertingPlugin(underlying)
}

case class ConfigEntry(key: String, desc: String)