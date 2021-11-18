package com.github.khoalas.testplugin.services

import com.intellij.openapi.project.Project
import com.intellij.xdebugger.XDebugProcess
import com.intellij.xdebugger.XDebugSessionListener
import com.intellij.xdebugger.XDebuggerManager
import com.intellij.xdebugger.XDebuggerManagerListener
import org.jetbrains.annotations.NotNull


class MyProjectService(project : Project){

    init {
        project.messageBus.connect().subscribe(XDebuggerManager.TOPIC, object : XDebuggerManagerListener {
            @Override
            override fun processStarted(@NotNull debugProcess: XDebugProcess) {
                println("started")
                attachDebugListener(debugProcess)
            }
        })
    }

    private fun attachDebugListener(debugProcess: XDebugProcess) {
            debugProcess.session.addSessionListener(object: XDebugSessionListener{
                override fun sessionPaused() {
                    println(debugProcess.session.currentStackFrame)
                }
            })
    }
}