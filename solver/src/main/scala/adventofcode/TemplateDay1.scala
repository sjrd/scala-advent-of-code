// using scala 3.0.1

package adventofcode

import scala.io.Source

object TemplateDay1:
  @main def run(file: String) =
    val input = Source.fromFile(file).iter.mkString
    part1(input)
    part2(input)

  def part1(input: String): String = computeAnswer(input, 2)

  def part2(input: String): String = computeAnswer(input, 3)

  private def computeAnswer(input: String, n: Int): String =
    val entries = input.split('\n').map(_.toInt).toSeq
    val combinations = entries.combinations(n)
    combinations.find(_.sum == 2020)
      .map(_.product.toString)
      .getOrElse(throw new Exception("No solution found"))
