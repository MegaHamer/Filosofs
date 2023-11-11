class Filosof(var name:String) {
    var itemsInHands = 0;
    var itemsInLeftHand = 0;
    var itemsInRightHand = 0;
    fun getFork (rightFilosof: Filosof,leftFilosof: Filosof, mode:Int):Boolean{
        var boo = true
        when ((0..1).random()){
            0->{//взять слева
                if (getLeft(leftFilosof,mode)){
                    println("Философ ${name} взял вилку справа")
                }
                else if (getRight(rightFilosof,mode)){
                    println("Философ ${name} взял вилку слева")
                }
                else{
                    boo = false
                    println("Философ ${name} призадумался")
                }
            }
            1->{//взять справа
                if (getRight(rightFilosof,mode)){
                    println("Философ ${name} взял вилку справа")
                }
                else if (getLeft(leftFilosof,mode)){
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
    fun getStick (rightFilosof: Filosof,leftFilosof: Filosof, stickCount:Int=1):Boolean{
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
            println("Философ ${name} взял палкочку справа")
        }
        else if (itemsInRightHand == 1){
            println("Философ ${name} взял палкочку слева")
        }
        else if (itemsInHands ==0){
            println("Философ ${name} призадумался")
            boo=false
        }
        //println("Философ ${name}  справа ${itemsInRightHand}  слева ${itemsInLeftHand}  всего ${itemsInHands}")
        return boo
    }
    fun getSticks (rightFilosof: Filosof,leftFilosof: Filosof, stickCount:Int=2):Boolean{
        var boo = true
        for (i in 0..1){
            var rnd = (0..1).random();
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
        }
        if ( itemsInLeftHand == 2){
            println("Философ ${name} взял палкочки справа")
        }
        else if (itemsInRightHand == 2){
            println("Философ ${name} взял палкочки слева")
        }
        else if (itemsInRightHand == 1 && itemsInLeftHand ==1){
            println("Философ ${name} взял палкочки слева и справа")
        }
        else if (itemsInRightHand == 1 ){
            println("Философ ${name} взял палкочку слева")
        }
        else if ( itemsInLeftHand == 1){
            println("Философ ${name} взял палкочку справа")
        }
        else if (itemsInHands ==0){
            println("Философ ${name} призадумался")
            boo=false
        }
        //println("Философ ${name}  справа ${itemsInRightHand}  слева ${itemsInLeftHand}  всего ${itemsInHands}")
        return boo
    }
    private fun getLeft (naiborFilosof: Filosof, count:Int):Boolean{
        if (naiborFilosof.itemsInRightHand + this.itemsInLeftHand <count){
            this.itemsInLeftHand++
            this.itemsInHands++
            return true
        }
        else return false
    }
    private fun getRight (naiborFilosof: Filosof, count:Int):Boolean{
        if (naiborFilosof.itemsInLeftHand + this.itemsInRightHand < count){
            this.itemsInRightHand++
            this.itemsInHands++
            return true
        }
        else return false
    }
}