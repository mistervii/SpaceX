package com.msp.spacex.data.api

enum class ApiErrorCodeEnum constructor(val error:String) {

    CONNEXION_ERROR("connexion_error"),
    BAD_REQUEST("bad_request"),
    ACCESS_FORBIDDEN("access_forbidden"),
    RESOURCE_NOT_FOUND("resource_not_found"),
    INTERNAL_SERVER_ERROR("internal_server_error"),
    BAD_GATEWAY("bad_gateway"),
    RESOURCE_REMOVED_PERMANENTLY("resource_removed_permanently"),
    RESOURCE_MOVED_FOUND("resource_moved_found"),
    UNAUTHORIZED_ACCESS("unauthorized_access")


}