package com.gridness.assignment

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object ReferenceProvider {
    private var deviceID: String = ""

    fun setDeviceID(deviceID: String) {
        this.deviceID = deviceID
    }

    fun getBaseReference(): DatabaseReference {
        return FirebaseDatabase
            .getInstance()
            .getReference(deviceID)
    }
}