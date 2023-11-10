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
    var table:Array<Filosof> = arrayOf()
    for (i in 0 until count){
        print("Введите имя для философа: ")
        table += Filosof (readln())
    }
    val order = (0 until  count).shuffled()
    println("Выберите способ:")
    println("1.Вилки")
    println("2.Палочка")
    println("3.Палочка")
    when (readln()){
        "1"->{//вилки
            for (i in order){
                table[i].getFork(table[(i+count-1)%count],table[(i+count+1)%count],1)
            }
        }
        "2"->{//палка
            for (i in order){
                for (k in 0..1)
                table[i].getFork(table[(i+count-1)%count],table[(i+count+1)%count],1)
            }
        }
        "3"->{//палки
            for (i in order){
                table[i].getFork(table[(i+count-1)%count],table[(i+count+1)%count],2)
            }
        }
        else->{
            println("Нет такого варианта")
            exitProcess(1)
        }
    }
}