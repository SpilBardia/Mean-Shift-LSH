package msLsh

import org.apache.spark.mllib.linalg.{Vector, Vectors}
import spire.implicits._

/**
 * The class which compute centroïds
 */
case class Bary0() extends Serializable {

	/**
	 * Function which compute centroïds
	 */
  def bary(tab1:Array[(Vector,Double)],k:Int) : Vector = {
    val tab2 = tab1.map(_._1.toArray)
	  var bary1 = tab2.reduce(_+_)
	  bary1 = bary1.map(_/k)
	  Vectors.dense(bary1)
  }
}
