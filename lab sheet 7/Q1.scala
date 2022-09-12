    
case class Rational(numer:Int, denomi:Int) {

    require(denomi !=0, println("Denominator should not be equal to 0"))   //avoid 0 denominator

   def neg() ={
        
        if(this.denomi<0){
            Rational(this.numer,-this.denomi)
            
        }else{
            Rational(-this.numer,this.denomi)
        }
        
    }

    
    override def toString(): String = numer + "/" + denomi
}

object neg extends App {

    val x1 = Rational(-1,2)
    val x2 = Rational(1,-2)
    val x3 = Rational(1,2)
    val x4 = Rational(-1,-2)

    println(x1.neg())
    println(x2.neg())
    println(x3.neg())
    println(x4.neg())

}

