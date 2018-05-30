package Lab_5

import org.scalatest.FunSuite

class Tests5 extends FunSuite {

  test("Pow tail is running correctly"){
    val tail = new MyPow
    assert(tail.myPowTail( 2, 5) == 32.0)
  }

  test("my Pow is running correctly"){
    val pow = new MyPow
    assert(pow.myPow( 2, 5) == 32.0)
  }

  test("my max length consec tail is running correctly"){
    val tail = new MaxSequence
    val sequenceOfNumbers = List[Double](12.2, 14.0, 17.7, 14.5, 22.1, 18.4, 22.9, 100.0, 12.6, 15.6)
   assert(tail.getIndexIncSequenceTail( sequenceOfNumbers ) == 5)
  }

  test("my max length consec is running correctly"){
    val max = new MaxSequence
    val sequenceOfNumbers = List[Double](12.2, 14.0, 17.7, 14.5, 22.1, 18.4, 22.9, 100.0, 12.6, 15.6)
    assert(max.getIndexIncSequence(sequenceOfNumbers ) == 5)
  }
}
