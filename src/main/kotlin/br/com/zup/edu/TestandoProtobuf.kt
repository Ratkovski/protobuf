package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
                    .setLogradouro("Rua das Tabajara")
                    .setCep("89340-000")
                    .setComplemento("Casa 20")
                    .build())
        .build()

    println(request)
    //escrevemos o objeto
    request.writeTo(FileOutputStream("funcionario-request.bin"))
    //lemos o objeto
    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))
    request2.setCargo(Cargo.GERENTE).build()
    println(request2)


}