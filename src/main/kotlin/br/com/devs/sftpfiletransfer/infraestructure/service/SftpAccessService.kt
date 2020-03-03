package br.com.devs.sftpfiletransfer.infraestructure.service

import org.springframework.beans.factory.annotation.Value

abstract class SftpAccessService {
    @Value("\${SFTP_URL}")
    val host: String = ""

    @Value("\${SFTP_PORT}")
    val port: Int = 0

    abstract fun connect(): Boolean

    abstract fun login(): Boolean


}