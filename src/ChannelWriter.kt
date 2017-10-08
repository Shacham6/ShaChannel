interface ChannelWriter<in T> {
    fun send(vararg data: T)
}
