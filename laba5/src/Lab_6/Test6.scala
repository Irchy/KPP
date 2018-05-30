package Lab_6

import org.scalatest.{FlatSpec, Matchers}

class Test6 extends FlatSpec with Matchers{
  val source = List("Steve", "Tom", "John", "Daniel", "Bob")
  val answer = List( "Tom", "Bob", "John", "Steve", "Daniel")
  val lab6 = new Tasks
  "Task1 function" should "sorting list of string by lenght" in {
    assert(lab6.sortingList(source) === answer)
  }


  val list = List(1, 2, 4, 3)
  "Task2 function" should "find minimal number" in {
    assert(lab6.findMin(list) === 1)
  }

  "Task3 function" should "delete same key from Map" in {
    val src = Map(1 -> 1, 2 -> 1, 3 -> 2)
    val answ = Map(1 -> 1, 3 -> 2)
    assert(lab6.deleteSameKey(src) === answ)
  }

}
