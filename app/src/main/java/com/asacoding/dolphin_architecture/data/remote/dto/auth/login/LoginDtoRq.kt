package com.asacoding.dolphin_architecture.data.remote.dto.auth.login

import com.google.gson.annotations.SerializedName

data class LoginDtoRq(

   @SerializedName("userName")
   val userName: String? = null,

   @SerializedName("password")
   val password: String? = null,

   @SerializedName("flag")
   val flag: Int? = null
)






