package a

interface A {
    fun interfaceAFunc1()

    companion object {
        fun companionObjectFunc1() {
            println("companionObjectFunc1 invoked")
        }

        inline fun companionObjectFunc2(crossinline block: () -> String): A {
            println("companionObjectFunc2 invoked")
            return object : A {
                override fun interfaceAFunc1() {
                    println("interfaceAFunc1 invoked")
                    companionObjectFunc1()
                    println(block())
                }
            }
        }
    }
}
