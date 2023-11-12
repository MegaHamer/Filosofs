import kotlin.system.exitProcess

fun main() {
    println("Укажите число философов");
    var count:Int
    try {
        count = readln().toInt();
    }
    catch (e:Exception){
        println("Это не число");
        exitProcess(1)
    }
    while (true){
    var table:Array<Filosof> = arrayOf()
    for (i in 0 until count){
        print("Введите имя для философа: ")
        table += Filosof ((i+1).toString())
        if (table[i].name == ""){
            table[i].name = (i+1).toString();
        }
    }

    val order = (0 until  count).shuffled()
    println("Выберите способ:")
    println("1.Вилки")
    println("2.Палочка")
    println("3.Палочка")
    when (readln()) {
        "1" -> {//вилки
            for (i in order) {
                table[i].getFork(table[(i + count - 1) % count], table[(i + count + 1) % count], 1)
            }
        }

        "2" -> {//палка
            for (i in order) {
                table[i].getStick(table[(i + count - 1) % count], table[(i + count + 1) % count], 1)
            }
        }

        "3" -> {//палки
            for (i in order) {
                table[i].getSticks(table[(i + count - 1) % count], table[(i + count + 1) % count], 2)
            }
        }

        else -> {
            println("Нет такого варианта")
            exitProcess(1)
        }
    }
    }
}