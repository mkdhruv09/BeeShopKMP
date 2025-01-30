package com.jetbrains.kmpapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("product") val product: Product
)

@Serializable
data class Product(
    @SerialName("id")
    var id: Long = 123456,

    @SerialName("title")
    var title: String = "",

    @SerialName("description")
    var description: String = "",

    /*@SerialName("handle")
    var handle: String,

    @SerialName("publishedAt")
    var publishedAt: String,

    @SerialName("publishedAt")
    var createdAt: String,

    @SerialName("price")
    val price: Double,

    @SerialName("available")
    var available: Boolean,*/

    @SerialName("images")
    val media: List<ProductMedia>,
) {

    companion object {
        const val PRODUCT_ID = "product_id"

        const val SAMPLE_IMAGE =
            "https://cdn.shopify.com/s/files/1/0782/3284/6646/files/6bd19479-2f39-4904-af0b-0862b5ae4409.jpg"

        const val SAMPLE_IMAGE2 =
            "https://cdn.shopify.com/s/files/1/0782/3284/6646/files/1fd09779-c155-4cd0-9edc-858942ed31b4_e6adad4f-fbb7-449a-b92b-2dd229068b81.jpg"

        const val SAMPLE_TITLE =
            "4887 PLAY GAME TRANSPARENT FUNNY TRAIN ENGINE WITH BLOCKS SET 60 BLOCKS TOY WITH MUSIC AND LIGHTS AUTOMATIC BLOCKS TOY TRAIN  SET FOR KIDS (BATTERIES NOT INCLUDED)"

        const val SAMPLE_DESCRIPTION =
            "Train Set with Tracks. Comes With Realistic Sounds, Flashlight and The Train Chugs On The Tracks.\n" +
                    "\n" +
                    "Push one and watch the chain effect of the block tumbling over like a race.\n" +
                    "\n" +
                    "Block train blocks set is made of high-quality plastic which is, no bpa or any other harmful substances.\n" +
                    "\n" +
                    "The train will move forward and lay block automatically while twisting left and right slowly.\n" +
                    "\n" +
                    "The Train Will Move Forward And Lay Dominoes Automatically While Twisting Left And Right Slowly.\n" +
                    "\n" +
                    "Excellent Gift Choice - Perfect for children’s birthday surprises and puzzle games, thereby bring happy entertainment time for children ages 3 years and up. Especially if you and your children/grandson are fans of domino racing.\n" +
                    "\n" +
                    "Package included - 1 train and colourful Block, requires 2 aa batteries (not included).\n"
    }
}

@Serializable
data class ProductMedia(@SerialName("src") val src: String)