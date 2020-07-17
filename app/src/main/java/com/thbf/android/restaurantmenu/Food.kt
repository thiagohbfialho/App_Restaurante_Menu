package com.thbf.android.restaurantmenu

class Food {
    var name:String ?= null
    var des:String ?= null
    var image:Int ?= 0
    constructor(name: String, des:String, image:Int){
        this.name = name
        this.des = des
        this.image = image
    }
}