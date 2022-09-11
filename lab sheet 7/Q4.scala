
class Account(val accNo: Int, var balance: Double){

    def withdrow(amount:Double) : Unit = {
        this.balance = this.balance - amount
    }

    def deposit(amount:Double) : Unit = {
        this.balance = this.balance + amount
    }

}


object test extends App{

    var accountList:List[Account] = List()
    var negList:List[Account]=List()

    def create(accNo:Int, balance:Double):Unit = {
        var acc = new Account(accNo,balance)
        accountList = accountList ::: acc ::Nil        //add each acount to list
    }
    
    //find negative balance
    def neg(li:List[Account]):Unit={

        for{
            i <- li
            if i.balance < 0
        }yield {
            negList=negList:::i::Nil           //new list 
        }
        display(negList)
    }


    //get summation of balance
    def sum(li:List[Account]):Double={
        var sum:Double=0
        for{
            i <- li
        }yield{
            sum=sum+i.balance
        }
        sum
    }

    //applying interest to balance
    def interest(li:List[Account], depoRate:Double, overdraft:Double):Any={
        for{
            i <- li           
            if i.balance < 0        // negative balance

        }yield{
            i.balance=i.balance*overdraft+i.balance
        }

        for{
            j <- li
            if j.balance > 0        // positive balance

        }yield{
            j.balance=j.balance*depoRate+j.balance
        }
        sum(li)
    }

    //print accounts 
    def display(li:List[Account]):Unit={
        for{
            i <- li
        }yield
            println("Account No:"+i.accNo+" balance: Rs. "+i.balance)
    }

    create(1,-500)
    create(2,200)
    create(3,0)
    create(4,1000)
    create(5,-10)

    println(" ")
    println("Accounts with negative balance:- ")
    neg(accountList)
    println(" ")
    println("Sum of all account balances is: Rs. "+sum(accountList))
    println("After apply interest sum of all account balances is: Rs. "+interest(accountList,0.05,0.1))
    println(" ")

}
