package Lab_6

class Tasks {

  def sortingList(list: List[String]): List[String] =
    list.sortWith((x, y) => x.length() < y.length())

  def findMin(list: List[Int]): Int = {
    list.foldLeft(list.head) { (m: Int, n: Int) => if (m > n) n; else m }
  }

  def deleteSameKey(map : Map[Int,Int]): Map[Int,Int] = {
    map.foldRight(Map[Int, Int]())((x, acc) => acc + ((x._2, x._1))).foldLeft(Map[Int, Int]())((acc, x) => acc + ((x._2, x._1)))
  }

}
