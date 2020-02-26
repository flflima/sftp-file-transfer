package br.com.devs.sftpfiletransfer.infraestructure.service.implementation

import br.com.devs.sftpfiletransfer.domain.exceptions.SFTPException
import br.com.devs.sftpfiletransfer.infraestructure.service.SftpAccessService
import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTPReply
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class SftpUserPasswordImpl @Autowired constructor(val client: FTPClient) : SftpAccessService() {

    @Value("\${SFTP_USER}")
    private val username: String = ""

    @Value("\${SFTP_PASSWORD}")
    private val password: String = ""

    override fun connect(): Boolean {
        client.connect(host, port)

        val replyCode = client.replyCode

        return FTPReply.isPositiveCompletion(replyCode).apply {
            println("Operation failed. Server reply code: $replyCode")
        }
    }

    override fun login(): Boolean {
        return client.login(username, password).apply {
            println("Operation failed. Server reply code: ${client.replyCode}")
        }
    }

    fun execute() {
        if (connect()) {
            println("Success")
            if (login()) {
                println("Success")
            } else {
                println("Login Unsuccessful")
                throw SFTPException(message = "Login Unsuccessful")
            }
        } else {
            println("Connection Unsuccessful")
            throw SFTPException(message = "Connection Unsuccessful")
        }
    }

}