package Lab_7

object Task1 {
  def main(args: Array[String]): Unit = {

    println(calcS(5,"12s"))
  }

  def calcS(v: Float, t: String): Float = {
    t.last match {
      case 's' => v * cutToInt(t)
      case 'm' => v * cutToInt(t) * 60
      case 'h' => v * cutToInt(t) * 3600

    }
  }

  def cutToInt (s: String): Int = {
    s.init.toInt
  }
}
