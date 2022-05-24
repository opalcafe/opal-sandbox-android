package xyz.cloudcoffee.opalandroid.pattern.decorator


interface Coffee {
    fun getDescription(): String
    fun buildExtras(arrayList: ArrayList<String>)
}

open abstract class CoffeeExtra(val theCoffee : Coffee) {

}



class Expresso(): Coffee {
    override fun getDescription(): String {
        return "Expresso"
    }

    override fun buildExtras(extras: ArrayList<String>) {
        extras.add("Expresso")

    }


}

class SugarExtra(coffee: Coffee): CoffeeExtra(coffee), Coffee {
    override fun getDescription(): String {
        return theCoffee.getDescription() + "\nwith Sugar"
    }

    override fun buildExtras(extras: ArrayList<String>) {
        extras.add("Sugar")
    }
}

class FrostExtra(coffee: Coffee): CoffeeExtra(coffee), Coffee {
    override fun getDescription(): String {
        TODO("Not yet implemented")
    }

    override fun buildExtras(arrayList: ArrayList<String>) {
        TODO("Not yet implemented")
    }

}


fun coffeeMain(){

    val coffee = SugarExtra(Expresso())

    


}