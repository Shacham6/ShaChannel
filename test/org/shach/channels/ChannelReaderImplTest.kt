package org.shach.channels

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.concurrent.LinkedTransferQueue

internal class ChannelReaderImplTest {
    @Test
    fun testBasicReading() {
        val queue = LinkedTransferQueue<String>()
        val reader = ChannelReaderImpl<String>(queue)
        queue.add("Praise The Sun!!")
        assertEquals("Praise The Sun!!", reader.receive())
    }
}