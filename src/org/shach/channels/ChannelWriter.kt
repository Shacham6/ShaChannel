package org.shach.channels

interface ChannelWriter<in T> {
    fun send(vararg data: T)
}
