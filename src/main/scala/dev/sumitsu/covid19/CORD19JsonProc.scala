package dev.sumitsu.covid19

import com.spotify.scio._
import com.spotify.scio.extra.json._
import dev.sumitsu.covid19.CORDJsonSchema.CORDJsonDocument

object CORD19JsonProc {

  def main(cmdlineArgs: Array[String]): Unit = {
    val (sc, args) = ContextAndArgs(cmdlineArgs)
    val input = args("input")
    val output = args("output")

    sc.jsonFile[CORDJsonDocument](input).map(_.toString).saveAsTextFile(output)

    val result = sc.run().waitUntilFinish()
  }

}
