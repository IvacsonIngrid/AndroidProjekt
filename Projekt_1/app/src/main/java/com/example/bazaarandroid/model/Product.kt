package com.example.bazaarandroid.model

import com.squareup.moshi.JsonClass

data class MyProduct(
    var title: String = "rossz",
    var description: String = "",
    var price_per_unit: String = "",
    var units: String = "",
    var is_active: Boolean = true,
    var rating: Double = 3.5,
    var amount_type: String = "",
    var price_type: String = ""
)

@JsonClass(generateAdapter = true)
data class Image(val _id: String, val image_id: String, val image_name: String, val image_path: String)

@JsonClass(generateAdapter = true)
data class Product(val rating: Double,
                   val amount_type: String,
                   val price_type: String,
                   val product_id: String,
                   val username: String,
                   val is_active: Boolean,
                   val price_per_unit: String,
                   val units: String,
                   val description: String,
                   val title: String,
                   val images: List<Image>,
                   val creation_time: Long
)

@JsonClass(generateAdapter = true)
data class Orders(val order_id: String,
                   val username: String,
                   val status: String,
                   val owner_username: String,
                   val price_per_unit: String,
                   val units: String,
                   val description: String,
                   val title: String,
                   val creation_time: String,
                   val images: List<Image>,
                   val message:List<Message>
)

@JsonClass(generateAdapter = true)
data class Message(val username: String,
                  val message_id: String,
                  val message: String,
                  val creation_time: Long
)

@JsonClass(generateAdapter = true)
data class ProductResponse(val item_count: Int, val products: List<Product>, val timestamp: Long)

@JsonClass(generateAdapter = true)
data class ProductSalesResponse(val item_count: Int, val orders: List<Orders>, val timestamp: Long)

@JsonClass(generateAdapter = true)//beadom
data class AddProductRequest(
    var title: String,
    var description: String,
    var price_per_unit: String,
    var is_active: Boolean,
    var rating: Double,
    var amount_type: String,
    var units: String,
    var price_type: String
)

@JsonClass(generateAdapter = true)//visszakapom
data class AddProductResponse(
    var creation: String,
    var product_id: String,
    var username: String,
    var title: String,
    var description: String,
    var price_per_unit: String,
    var is_active: Boolean,
    var amount_type: String,
    var units: String,
    var rating: String,
    var creation_time: String,
    var price_type: String
)

@JsonClass(generateAdapter = true)
data class UpdateProduct(
    var price_per_unit: String,
    var is_active: Boolean,
    var title: String,
    var rating: String,
    var amount_type: String,
    var price_type: String
)