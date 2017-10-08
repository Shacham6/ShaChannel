package org.shach.channels

import java.util.concurrent.TransferQueue

internal class ChannelWriterImpl<in T>(private val dataQueue: TransferQueue<T>) : ChannelWriter<T> {
    override fun send(vararg data: T) {
        for (item in data) {
            dataQueue.transfer(item)
        }
    }
}
