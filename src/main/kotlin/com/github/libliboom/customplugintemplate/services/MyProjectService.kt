package com.github.libliboom.customplugintemplate.services

import com.intellij.openapi.project.Project
import com.github.libliboom.customplugintemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
