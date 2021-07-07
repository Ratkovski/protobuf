package br.com.zup.edu

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

fun main() {
    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()


    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri")
        .setCpf("000.000.000-00")
        .setIdade(23)
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua das Tabajara")
            .setCep("89340-000")
            .setComplemento("Casa 20")
            .build())
        .build()



    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    client.cadastrar(request)
    val response = client.cadastrar(request)
    println()
}