---
sidebar_position: 1
---

# Template - Day N: Report Repair 
by @adpi2

## Puzzle description

https://adventofcode.com/2020/day/1

You must log in to get your input file.

## Solution of Part 1

```scala mdoc:js
import org.scalajs.dom.document
import org.scalajs.dom.window._
import org.scalajs.dom.html._
import jsdocs.Progress

val progress = Progress()
setInterval({ () =>
  // `node` variable is a DOM element in scope.
  node.innerHTML = progress.tick(5)
}, 100)
```

```scala mdoc:js:shared
def part1(input: List[String]): String = 
  // read the input as a sequence of Int
  val entries: Seq[Int] = input.map(_.toInt).toSeq
  
  // compute all the pairs of entries
  val pairs: Seq[(Int, Int)] =
    for 
      (x, i) <- entries.zipWithIndex
      y <- entries.drop(i)
    yield (x, y)
  
  // find the pair whose product is 2020
  val solution = pairs.find((x, y) => x * y == 2020)

  // print the solution
  solution match
    case Some((x, y)) => "The solution is ${x * y}"
    case None => "No solution found"
```

```scala mdoc:js:invisible
<p>here</p>
---
node.innerHTML = part1(List(1,2,3).map(_.toString))
```
