package com.asacoding.dolphin_architecture.common.constants

import com.asacoding.dolphin_architecture.BuildConfig


/**
 * Object containing constant values used throughout the application.
 */
object Constants {

    /** Base URL for API endpoints */
    const val BASE_URL = "BuildConfig.BASE_URL"

    /** Tag used for logging messages related to application lifecycle */
    const val TAG_MESSAGE = "LifeCycleApplication"

    /**
     * Version name of the application.
     * If the build is in debug mode, the version name includes "rc" (release candidate) followed by the version code.
     * Otherwise, it includes "r" (release) followed by the version code.
     */
    val VERSION_NAME = if (BuildConfig.DEBUG) "${BuildConfig.VERSION_NAME}rc${BuildConfig.VERSION_CODE}" else "${BuildConfig.VERSION_NAME}r${BuildConfig.VERSION_CODE}"

    /**
     * Network And Local
     */
    const val PREFERENCE_NAME =  "app_prefs"
    const val TIME_OUt : Long=  90

}
