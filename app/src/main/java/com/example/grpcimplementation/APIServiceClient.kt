package com.example.grpcimplementation




class APIServiceClient(host: String, port: Int) {
    private val channel: ManagedChannel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext()
        .build()
    private val stub: APIServiceGrpc.APIServiceBlockingStub =
        APIServiceGrpc.newBlockingStub(channel)

    fun fetchData(request: RequestData): ResponseData {
        return stub.fetchData(request)
    }

    fun shutdown() {
        channel.shutdown()
    }
}