package Lab_5

import scala.annotation.tailrec

class MyPow {

  def myPow(num:Int, pow:Int): Double ={
    if (pow == 1) num
    else num*myPow(num, pow-1)
  }

  def myPowTail(num:Int, pow:Int): Double ={
    @tailrec
    def iter (acc: Int, num:Int, pow:Int): Double ={
      if (pow == 0) acc
      else iter(acc*num, num, pow-1)
    }
    iter(1, num, pow)
  }

}
