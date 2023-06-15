package com.example.grpcimplementation

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.cast.RequestData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        apiServiceClient = APIServiceClient("api.example.com", 50051)

        // Call an asynchronous task to fetch data from the API
        val fetchDataTask = FetchDataTask()
        fetchDataTask.execute()
    }

    private inner class FetchDataTask : AsyncTask<Void, Void, ResponseData>() {
        override fun doInBackground(vararg params: Void): ResponseData {
            // Prepare your request data
            val request = RequestData.newBuilder()
                // Set request message fields...
                .build()

            return apiServiceClient.fetchData(request)
        }
}