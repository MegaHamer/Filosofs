class Filosof(var name:String) {
    var itemsInHands = 0;
    var itemsInLeftHand = 0;
    var itemsInRightHand = 0;
    fun getFork (leftFilosof: Filosof,rightFilosof: Filosof, ForkCount:Int):Boolean{
        var boo = true
        when ((0..1).random()){
            0->{//взять слева
                if (getLeft(leftFilosof,ForkCount)){
                    println("Философ ${name} взял вилку СЛЕВА")
                }
                else if (getRight(rightFilosof,ForkCount)){
                    println("Философ ${name} взял вилку СПРАВА")
                }
                else{
                    boo = false
                    println("Философ ${name} призадумался")
                }
            }
            1->{//взять справа
                if (getRight(rightFilosof,ForkCount)){
                    println("Философ ${name} взял вилку справа")
                }
                else if (getLeft(leftFilosof,ForkCount)){
                    println("Философ ${name} взял вилку слева")
                }
                else {
                    boo=false
                    println("Философ ${name} призадумался")
                }
            }
        }
        return boo
    }
    fun getStick (leftFilosof: Filosof,rightFilosof: Filosof, stickCount:Int=1):Boolean{
        var boo = true
        var rnd = (0..1).random();
        for (i in 0..1){

            when (rnd){
                0->{//левая
                    getLeft(leftFilosof,stickCount)
                    //println(" левый Философ ${leftFilosof.name}  справа ${leftFilosof.itemsInRightHand}  слева ${leftFilosof.itemsInLeftHand}  всего ${leftFilosof.itemsInHands}")
                }
                1->{//правая
                    getRight(rightFilosof,stickCount)
                    // println(" правый Философ ${rightFilosof.name}  справа ${rightFilosof.itemsInRightHand}  слева ${rightFilosof.itemsInLeftHand}  всего ${rightFilosof.itemsInHands}")
                }
            }
            rnd = (rnd+1)%2
        }
        if ( itemsInHands == 2){
            println("Философ ${name} взял палкочку слева и справа")
        }
        else if (itemsInLeftHand == 1){
            println("Философ ${name} взял палкочку слева")
        }
        else if (itemsInRightHand == 1){
            println("Философ ${name} взял палкочку справа")
        }
        else if (itemsInHands ==0){
            println("Философ ${name} призадумался")
            boo=false
        }
        //println("Философ ${name}  справа ${itemsInRightHand}  слева ${itemsInLeftHand}  всего ${itemsInHands}")
        return boo
    }
    fun getSticks (leftFilosof: Filosof,rightFilosof: Filosof, stickCount:Int=2):Boolean{
        var boo = true
        for (i in 0..1){
            var rnd = (0..1).random();
            when (rnd){
                0->{//левая
                    if (!getLeft(leftFilosof,stickCount)){
                        getRight(rightFilosof,stickCount)
                    }
                    //println(" левый Философ ${leftFilosof.name}  справа ${leftFilosof.itemsInRightHand}  слева ${leftFilosof.itemsInLeftHand}  всего ${leftFilosof.itemsInHands}")
                }
                1->{//правая
                    if (!getRight(rightFilosof,stickCount)){
                        getLeft(leftFilosof,stickCount)
                    }
                    // println(" правый Философ ${rightFilosof.name}  справа ${rightFilosof.itemsInRightHand}  слева ${rightFilosof.itemsInLeftHand}  всего ${rightFilosof.itemsInHands}")
                }
            }
        }
        if ( itemsInLeftHand == 2){
            println("Философ ${name} взял 2 палкочки слева")
        }
        else if (itemsInRightHand == 2){
            println("Философ ${name} взял 2 палкочки справа")
        }
        else if (itemsInRightHand == 1 && itemsInLeftHand ==1){
            println("Философ ${name} взял палкочки слева и справа")
        }
        else if (itemsInRightHand == 1 ){
            println("Философ ${name} взял 1 палкочку справа")
        }
        else if ( itemsInLeftHand == 1){
            println("Философ ${name} взял 1 палкочку слева")
        }
        else if (itemsInHands ==0){
            println("Философ ${name} призадумался")
            boo=false
        }
        //println("Философ ${name}  справа ${itemsInRightHand}  слева ${itemsInLeftHand}  всего ${itemsInHands}")
        return boo
    }
    private fun getLeft (leftFilosof: Filosof, count:Int):Boolean{
        println(" левый Философ ${leftFilosof.name}  справа ${leftFilosof.itemsInRightHand}  слева ${leftFilosof.itemsInLeftHand}  всего ${leftFilosof.itemsInHands}")
        println(leftFilosof.itemsInRightHand + this.itemsInLeftHand <count)
        if (leftFilosof.itemsInRightHand + this.itemsInLeftHand <count){
            this.itemsInLeftHand++
            this.itemsInHands++
            return true
        }
        else return false
    }
    private fun getRight (rightFilosof: Filosof, count:Int):Boolean{
        println(" правый Философ ${rightFilosof.name}  справа ${rightFilosof.itemsInRightHand}  слева ${rightFilosof.itemsInLeftHand}  всего ${rightFilosof.itemsInHands}")
        println(rightFilosof.itemsInLeftHand + this.itemsInRightHand <count)
        if (rightFilosof.itemsInLeftHand + this.itemsInRightHand < count){
            this.itemsInRightHand++
            this.itemsInHands++
            return true
        }
        else return false
    }
}