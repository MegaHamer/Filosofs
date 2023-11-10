class Filosof(var name:String) {
    var itemsInHands = 0;
    var itemsInLeftHand = 0;
    var itemsInRightHand = 0;
    fun getFork (rightFilosof: Filosof,leftFilosof: Filosof, mode:Int):Boolean{
        var boo = true
        when ((0..1).random()){
            0->{//взять слева
                if (getLeft(leftFilosof,mode)){
                    println("Философ ${name} взял вилку слева")
                }
                else if (getRight(rightFilosof,mode)){
                    println("Философ ${name} взял вилку справа")
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
    fun getStick (rightFilosof: Filosof,leftFilosof: Filosof, mode:Int):Boolean{
        var boo = true
        when ((0..1).random()){
            0->{//взять слева
                if (getLeft(leftFilosof,mode)){
                    println("Философ ${name} взял вилку слева")
                }
                else if (getRight(rightFilosof,mode)){
                    println("Философ ${name} взял вилку справа")
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
    private fun getLeft (naiborFilosof: Filosof, count:Int):Boolean{
        if (naiborFilosof.itemsInRightHand <= count-1 && this.itemsInLeftHand <=count-1){
            this.itemsInLeftHand++
            this.itemsInHands++
            return true
        }
        else return false
    }
    private fun getRight (naiborFilosof: Filosof, count:Int):Boolean{
        if (naiborFilosof.itemsInLeftHand <= count-1 && this.itemsInRightHand <= count-1){
            this.itemsInRightHand++
            this.itemsInHands++
            return true
        }
        else return false
    }
}