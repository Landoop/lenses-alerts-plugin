/*
 * Copyright 2017-2019 Lenses.io Ltd
 */
package io.lenses.alerting.plugin.scalaapi

import io.lenses.alerting.plugin.{Alert => JAlert}
import io.lenses.alerting.plugin.javaapi.{AlertingService => JAlertingService}
import io.lenses.alerting.plugin.scalaapi.util.TryUtils._

import scala.jdk.CollectionConverters._
import scala.collection.mutable
import scala.util.Try

/**
  * simple alerting service wrapper giving Scala users a bit more type information
  */
class AlertingService(underlying: JAlertingService) {

  def publish(alert: JAlert): Try[JAlert] = Try {
    underlying.publish(alert).asScala
  }.flatten

  def name: String = underlying.name()

  def description: String = underlying.description()

  def displayedInformation: mutable.Map[String, String] = underlying.displayedInformation().asScala
  }

object AlertingService {
  def apply(underlying: JAlertingService): AlertingService = new AlertingService(underlying)
}
