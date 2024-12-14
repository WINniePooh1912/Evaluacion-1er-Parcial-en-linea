package com.example.parcial1

open class Producto {
    var sku: Int
    var material: String

    constructor() {
        sku = 0
        material = ""
    }

    constructor(sku: Int, material: String) {
        this.sku = sku
        this.material = material
    }
}