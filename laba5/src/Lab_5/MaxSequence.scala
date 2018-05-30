package Lab_5

import scala.annotation.tailrec

class MaxSequence {

 /* def getListSumTail(list: List[Double]): Double = {
    val size = list.length

    @tailrec
    def accumulator(acc: Double, list: List[Double], size: Int): Double = {
      if (size != 0)
        accumulator(acc + list(size - 1), list, size - 1)
      else
        acc
    }

    accumulator(0, list, size)
  }

  def getListSum(list: List[Double]): Double = {

    val size = list.length

    def accumulator(list: List[Double], size: Int): Double = {
      if (size != 0)
        list(size - 1) + accumulator(list, size - 1)
      else
        0
    }

    accumulator(list, size)
  }*/

  //with tail rec
  def getIndexIncSequenceTail(list: List[Double]): Int = {
    val size = list.length

    def getDifference(firstParam: Double, secondParam: Double): Double = {
      secondParam - firstParam
    }

    @tailrec
    def findMaxSequence(list: List[Double], size: Int, minIndex: Int,
                        maxDifference: Double, currIndex: Int, currMinIndex: Int): Int = {
      if (currIndex != size) {
        if (list(currIndex) < list(currIndex - 1)) {
          val difference = getDifference(list(currMinIndex), list(currIndex - 1))

          if (difference > maxDifference)
            findMaxSequence(list, size, currMinIndex, difference, currIndex + 1, currIndex)
          else
            findMaxSequence(list, size, minIndex, maxDifference, currIndex + 1, currIndex)
        } else
          findMaxSequence(list, size, minIndex, maxDifference, currIndex + 1, currMinIndex)
      } else if (getDifference(list(currMinIndex), list(currIndex - 1)) > maxDifference)
        currMinIndex
      else if (getDifference(list(currMinIndex), list(currIndex - 1)) > maxDifference)
        currMinIndex
      else
        minIndex
    }

    findMaxSequence(list, size, 0, 0, 1, 0)
  }


  //without tail rec
  def getIndexIncSequence(list: List[Double]): Int = {
    val size = list.length

    def getDifference(firstParam: Double, secondParam: Double): Double = {
      secondParam - firstParam
    }

    def findMaxSequence(list: List[Double], size: Int, minIndex: Int,
                        maxDifference: Double, currIndex: Int, currMinIndex: Int, acc: Int): Int = {
      if (currIndex == size) {
        -acc
      } else if (list(currIndex) < list(currIndex - 1)) {
        if (maxDifference < getDifference(list(currMinIndex), list(currIndex - 1))) {
          1 + findMaxSequence(list, size, currMinIndex,
            getDifference(list(currMinIndex), list(currIndex - 1)), currIndex + 1,
            currIndex, currIndex - currMinIndex)
        } else {
          1 + findMaxSequence(list, size, currMinIndex,
            maxDifference, currIndex + 1,
            currIndex, acc + 1)
        }
      } else if (currIndex == size - 1) {
        if (maxDifference < getDifference(list(currMinIndex), list(currIndex))) {
          1 + findMaxSequence(list, size, currMinIndex,
            getDifference(list(currMinIndex), list(currIndex)), currIndex + 1,
            currIndex, currIndex - currMinIndex)
        } else {
          1 + findMaxSequence(list, size, currMinIndex,
            maxDifference, currIndex + 1,
            currMinIndex, acc + 1)
        }
      } else {
        1 + findMaxSequence(list, size, currMinIndex,
          maxDifference, currIndex + 1,
          currMinIndex, acc + 1)
      }
    }
    findMaxSequence(list, size, 0, 0, 1, 0, 1)
  }
}
