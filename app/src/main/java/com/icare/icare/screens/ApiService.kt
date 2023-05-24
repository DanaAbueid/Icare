package com.icare.icare.screens

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.icare.icare.models.Patient

interface ApiService {
    // ... other endpoints

    @POST("api/users/signup/patient")
    suspend fun createPatient(@Body patient: Patient): Response<Patient>
}