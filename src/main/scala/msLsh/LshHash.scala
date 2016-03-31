package msLsh

import org.apache.spark.mllib.linalg.Vector

/**
 * The class which transform vector to scalar thank's to LSH
 */
case class LshHash() extends Serializable  {
  def hashfunc(x:Vector, w:Double, b:Double, tabHash1:Array[Array[Double]]) : Double = {
    var tabHash : Array[Double] = Array()
	  val x1 = x.toArray
	  for( ind <- tabHash1.indices) {
	    var sum = 0.0
	    for( ind2 <- x1.indices) {
	      sum = sum + (x1(ind2)*tabHash1(ind)(ind2))
	  	  }
	    tabHash =  tabHash :+ (sum+b)/w
	  }
	  tabHash.sum
  }
}
