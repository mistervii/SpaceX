package com.msp.spacex.utils

import com.msp.spacex.data.api.ApiErrorCodeEnum
import retrofit2.Response


fun <P,V> Response<P>.handleResponse(onSuccess: (data :P?) -> Results<V> , onError: (error: String) -> Results.Error) : Results<V> {


    return if (isSuccessful){
        if (body() != null){
            onSuccess(body()!!)
        }else{
            onSuccess(body())
        }
    }else{
        var error = ApiErrorCodeEnum.CONNEXION_ERROR.error
        when(code()){
            400 -> error = ApiErrorCodeEnum.BAD_REQUEST.error
            403 -> error = ApiErrorCodeEnum.ACCESS_FORBIDDEN.error
            404 -> error = ApiErrorCodeEnum.RESOURCE_NOT_FOUND.error
            500 -> error = ApiErrorCodeEnum.INTERNAL_SERVER_ERROR.error
            502 -> error = ApiErrorCodeEnum.BAD_GATEWAY.error
            301 -> error = ApiErrorCodeEnum.RESOURCE_REMOVED_PERMANENTLY.error
            302 -> error = ApiErrorCodeEnum.RESOURCE_MOVED_FOUND.error
            401 -> error = ApiErrorCodeEnum.UNAUTHORIZED_ACCESS.error

        }
        onError(error)
    }
}

