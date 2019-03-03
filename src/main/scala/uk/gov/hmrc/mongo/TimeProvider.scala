/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.mongo

import java.time.{Clock, ZoneId, ZonedDateTime}

import org.joda.time.{DateTime, DateTimeZone}

class TimeProvider {
  protected val jodaZone: DateTimeZone = DateTimeZone.UTC

  protected val javaUtcClock = Clock.systemUTC()

  @deprecated("Please use `currentTime` method")
  def withCurrentTime[A](f: DateTime => A) = f(DateTime.now.withZone(jodaZone))

  def currentTime[A](f: ZonedDateTime  => A) = f(ZonedDateTime.now(javaUtcClock))
}
