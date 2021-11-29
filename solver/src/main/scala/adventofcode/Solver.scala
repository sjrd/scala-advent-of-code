package adventofcode

import org.scalajs.dom
import com.raquo.laminar.api.L.*
import scala.util.Try
import scala.util.Failure
import scala.util.Success

val puzzles: Map[String, String => String] = Map(
  "template-day-1-part-1" -> TemplateDay1.part1,
  "template-day-1-part-2" -> TemplateDay1.part2
)

@main def solver(): Unit =
  println("Script started")
  dom.document.onreadystatechange = { e => 
    if dom.document.readyState.toString == "complete" then loadSolvers()
  }

def loadSolvers(): Unit =
  for (id, solution) <- puzzles do
    val div = dom.document.getElementById(id)
    if div != null then
      render(div, solverElement(solution))
    else println(s"cannot find $id")

def solverElement(solution: String => String): Element =
  val input = Var("")
  val answer = EventBus[Try[String]]()
  div(
    textArea(
      onChange.mapToValue --> input,
      width := "100%",
      placeholder := "Paste your input here",
      rows := 6
    ),
    br(),
    button(
      className := Seq("button", "button--secondary"),
      "Run Solution",
      onClick.mapTo(Try(solution(input.now()))) --> answer.writer
    ),
    child <-- answer.events.collect {
      case Failure(e) => 
        p(
          "Execution failed: ",
          p(
            styleAttr := "color: red",
            s"\t${e.getClass.getName}: ${e.getMessage}"
          )
        )
      case Success(answer) =>
        p(
          s"Answer is: ",
          span(
            styleAttr := "color: green",
            answer
          )
        )
    }
  )





