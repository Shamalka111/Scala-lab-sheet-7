
class Account(val accNo: Int, var balance: Double){

    //deducting
    def withdraw(amount:Double) : Unit = {
        this.balance = this.balance - amount
    }
    //deposit
    def deposit(amount:Double) : Unit = {
        this.balance = this.balance + amount
    }

    def transfer(receive:Account, amount:Double) : Unit = {
        
        if (this.balance < 0.0 || this.balance < amount){             //balance 0 or not enough to transfer
            println("Account "+this.accNo+" insufficient balance")
        }else {
            this.withdraw(amount)
            receive.deposit(amount)
            println(" ")
            println("Account "+this.accNo+" balance: "+this.balance)
            println("Account "+receive.accNo+" balance: "+receive.balance)
        }
    }
}

object transfer extends App{

    var no1=1
    var no1Balance=2000
    var no2=2
    var no2Balance=5000

    var acc1= new Account(no1,no1Balance)
    var acc2= new Account(no2,no2Balance)

    println("Account no "+acc1.accNo+ " balance - "+acc1.balance)
    println("Account no "+acc2.accNo+ " balance - "+acc2.balance)

    var send=scala.io.StdIn.readLine("Enter sender account number: ").toInt
    var receive=scala.io.StdIn.readLine("Enter receiver account number: ").toInt
    var Amount=scala.io.StdIn.readLine("Enter transfer amount: ").toDouble
    
    //check whether account number exist
    if(send == no1 || send == no2){
        if(receive == no1 || receive == no2){

            if(send == no1){
                acc1.transfer(acc2,Amount)
            }else{
                acc2.transfer(acc1,Amount)
            }
        }else{
            println("Invalid receiver account number")
        }
    }else{
        println("Invalid sender account number")
    }
}