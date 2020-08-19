package com.idn.whatsappclone.listeners

import com.idn.whatsappclone.utills.StatusListElement

interface ProgressListener {
    fun onProgressUpdate(progress: Int)
}

interface ChatClickListener {
    fun onChatClicked(name: String?, otherUserId: String?, chatsImageUrl: String?,
                      chatsName: String?)
}

interface ContactsClickListener {
    fun onContactClicked(name: String?, phone: String?)
}

interface FailureCallback {
    fun userError()
}

interface StatusItemClickListener {
    fun onItemClicked(statusElement: StatusListElement)
}
