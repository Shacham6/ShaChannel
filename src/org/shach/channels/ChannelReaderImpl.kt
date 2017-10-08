package org.shach.channels

import java.util.concurrent.TransferQueue

class ChannelReaderImpl<T>(private val dataQueue: TransferQueue<T>) : ChannelReader<T> {

    override fun receive(): T {
        return dataQueue.take()
    }

    @Throws(ChannelReaderException::class)
    override fun receive(waitDuration: Duration): T {
        return dataQueue.poll(waitDuration.time, waitDuration.timeUnit) ?: throw ChannelReaderException("Input not provided within the timeout duration")
    }

    override fun receiveOrDefaultWithinTimeout(waitDuration: Duration, defaultValue: T?): T? {
        return dataQueue.poll(waitDuration.time, waitDuration.timeUnit) ?: defaultValue
    }


    override fun clone(): ChannelReader<T> {
        return ChannelReaderImpl(dataQueue)
    }
}