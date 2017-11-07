package io.hydrosphere.slick

import com.github.tminglei.slickpg._
import slick.basic.Capability

trait HydrospherePostgresDriver extends ExPostgresProfile
  with PgArraySupport
  with PgDate2Support
  with PgSprayJsonSupport
  {
    def pgjson = "jsonb"

    override val api = new MyAPI {}

    override protected def computeCapabilities: Set[Capability] =
      super.computeCapabilities + slick.jdbc.JdbcCapabilities.insertOrUpdate

  //////
  trait MyAPI extends API
    with ArrayImplicits
    with DateTimeImplicits
    with JsonImplicits
}

object HydrospherePostgresDriver extends HydrospherePostgresDriver
