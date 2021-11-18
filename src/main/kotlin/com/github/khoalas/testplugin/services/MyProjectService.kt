package com.github.khoalas.testplugin.services

import com.intellij.openapi.project.Project
import com.github.khoalas.testplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
