    
case class Rational(numer:Int, denomi:Int) {

    require(denomi>0, println("Denominator must be greater than 0"))   //avoid 0 denominator

    def neg = Rational(-this.numer, this.denomi)
    
    override def toString(): String = numer + "/" + denomi
}

object neg extends App {

    val x1 = Rational(1,2)
    val x2 = Rational(4,5)

    println(x1.neg)
    println(x2.neg)

}

