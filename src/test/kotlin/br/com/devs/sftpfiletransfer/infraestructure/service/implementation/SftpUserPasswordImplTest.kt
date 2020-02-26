package br.com.devs.sftpfiletransfer.infraestructure.service.implementation

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.apache.commons.net.ftp.FTPClient
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SftpUserPasswordImplTest {

    private val client = mockk<FTPClient>(relaxed = true)
    private val sftpAccessService = SftpUserPasswordImpl(client)

    @Test
    fun `given a successful connection when connect to server must return true`() {

        every { client.connect(any<String>(), any()) } just Runs
        every { client.replyCode } returns 200

        assertTrue(sftpAccessService.connect())
    }

    @Test
    fun `given an unsuccessful connection when connect to server must return true`() {

        every { client.connect(any<String>(), any()) } just Runs
        every { client.replyCode } returns 400

        assertFalse(sftpAccessService.connect())
    }

    @Test
    fun `given a successful login when logging to server must return true`() {

        every { client.login(any(), any()) } returns true

        assertTrue(sftpAccessService.login())
    }

    @Test
    fun `given an unsuccessful login when logging to server must return true`() {

        every { client.login(any(), any()) } returns false

        assertFalse(sftpAccessService.login())
    }

    @Test
    fun `given a successful connection and login must not throw any exception`() {
        // TODO
    }

    @Test
    fun `given a successful connection but unsuccessful login must throw an exception`() {
        // TODO
    }

    @Test
    fun `given a unsuccessful connection but a successful login must throw an exception`() {
        // TODO
    }

    @Test
    fun `given a unsuccessful connection but a unsuccessful login must throw an exception`() {
        // TODO
    }

}