package net.gouline.gradlekt

//
//
// Type aliases

typealias Width = Double
typealias Height = Double
typealias Action<T> = (T) -> Unit

//
//
// Bound callable references

fun initHandler() {
    val handler = CustomHandler()
    testHandler(handler::handleIndex)
}

fun testHandler(method: (String) -> Unit) {
    method("/")
}

class CustomHandler {
    fun handleIndex(path: String) {
        println("Path: " + path)
    }
}

//
//
// Local delegated properties

fun testHugeEvaluator(type: String) {
    println("Enter method")

    val evaluator by lazy {
        println("Evaluator being created")
        SomeHugeEvaluator(type)
    }

    println("Before condition")

    if (type == "plus" || type == "minus") {
        println("Before evaluation")

        evaluator.evaluateStuff()

        println("After evaluation")
    }
}

class SomeHugeEvaluator(val type: String) {
    fun evaluateStuff() {
        println("Evaluating type: " + type)
    }
}

//
// Inline properties

class NumberGenerator {
    val random: Int
        inline get() = (Math.random() * 10).toInt()
}

//
//
// Data classes

open class Fruit

data class Apple(val type: String, val color: Int) : Fruit()

//
//
// Sealed classes

sealed class Expr {
    data class Const(val number: Double) : Expr()
    data class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}

fun eval(expr: Expr): Double = when (expr) {
    is Expr.Const -> expr.number
    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
    Expr.NotANumber -> Double.NaN
}
