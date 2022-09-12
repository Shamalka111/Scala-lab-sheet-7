
case class Rational(numer:Int, denomi:Int) {

    require(denomi!=0, println("Denominator should not be equal to 0"))    //avoid 0 denominator

    def add(r:Rational) = Rational(this.numer*r.denomi + this.denomi*r.numer, this.denomi*r.denomi)

    def neg() ={
        
        if(this.numer>0 && this.denomi<0){
            Rational(this.numer,-this.denomi)

        }else if(this.numer<0 && this.denomi<0){
            Rational(this.numer,-this.denomi)

        }else{
            Rational(-this.numer,this.denomi)
        }
        
    }


    def -(r:Rational)= this.add(r.neg())            //do negation and adding

    override def toString(): String = numer + "/" + denomi
}

object sub extends App {

    val x = Rational(3,4)
    val y = Rational(5,8)
    val z = Rational(2,7)

    val sol=x-y-z
    println(sol)

}
