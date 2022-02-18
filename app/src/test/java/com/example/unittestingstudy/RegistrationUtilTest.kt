package com.example.unittestingstudy

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `vaild username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "philipp",
            "123",
            "123"
        )

        assertThat(result).isTrue()
        assertThat("hello").isEqualTo("hello")
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }
    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "123456",
            "abcdefg"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "abcdefg",
            "abcdefg"
        )
        assertThat(result).isFalse()
    }
}