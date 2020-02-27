package br.com.devs.sftpfiletransfer.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SftpFileTransferApplication

fun main(args: Array<String>) {
	runApplication<SftpFileTransferApplication>(*args)
}
