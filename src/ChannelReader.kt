interface ChannelReader<out T> {
    fun receive(): T
}