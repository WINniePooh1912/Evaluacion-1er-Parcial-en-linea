package com.example.parcial1

class Tornillo: Producto {
    var lenght: String
    var headShape: String

    constructor() : super() {
        lenght = ""
        headShape = ""
    }

    constructor(sku: Int, material: String, lenght: String, headShape: String)
            : super(sku, material) {
        this.lenght = lenght
        this.headShape = headShape
    }

}