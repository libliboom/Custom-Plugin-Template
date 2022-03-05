package com.github.libliboom.customplugintemplate.template

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.libliboom.customplugintemplate.listeners.MyProjectManagerListener.Companion.projectInstance
import com.github.libliboom.customplugintemplate.manager.PackageManager
import com.github.libliboom.customplugintemplate.manager.Path.APP
import com.github.libliboom.customplugintemplate.manager.ProjectFileManager
import com.github.libliboom.customplugintemplate.manager.addPackageName
import com.github.libliboom.customplugintemplate.template.klass.createAction
import com.github.libliboom.customplugintemplate.template.klass.createActivity
import com.github.libliboom.customplugintemplate.template.klass.createDatasource
import com.github.libliboom.customplugintemplate.template.klass.createIDatasource
import com.github.libliboom.customplugintemplate.template.klass.createIRepository
import com.github.libliboom.customplugintemplate.template.klass.createMiddleware
import com.github.libliboom.customplugintemplate.template.klass.createPresentation
import com.github.libliboom.customplugintemplate.template.klass.createReducer
import com.github.libliboom.customplugintemplate.template.klass.createRepository
import com.github.libliboom.customplugintemplate.template.klass.createUsecase
import com.github.libliboom.customplugintemplate.template.klass.createViewModel
import com.github.libliboom.customplugintemplate.template.utils.asKt
import com.github.libliboom.customplugintemplate.template.utils.save

fun RecipeExecutor.cleanArchActivityTemplate(
  moduleData: ModuleTemplateData,
  packageName: String,
  className: String
) {
  val (projectData, _, _, manifestOut) = moduleData
  val project = projectInstance ?: return

  addAllKotlinDependencies(moduleData)
  addPackageName(packageName, projectData.applicationPackage.toString())

  val pfm = ProjectFileManager(project)
  if (pfm.init().not()) return

  createActivity(className = className, manifestOut = manifestOut, moduleData = moduleData)
    .save(pfm.dirOf(APP), packageName, "${className}Activity".asKt())

  createViewModel(className = className)
    .save(pfm.dirOf(APP), packageName, "${className}ViewModel".asKt())

  createPresentation(className = className)
    .save(pfm.dirOf(APP), PackageManager.presentationPackageName, "${className}Presentation".asKt())

  createAction(className = className)
    .save(pfm.dirOf(APP), PackageManager.presentationPackageName, "${className}Action".asKt())

  createMiddleware(className = className)
    .save(pfm.dirOf(APP), PackageManager.presentationPackageName, "${className}Middleware".asKt())

  createReducer(className = className)
    .save(pfm.dirOf(APP), PackageManager.presentationPackageName, "${className}Reducer".asKt())

  createDatasource(className = className)
    .save(pfm.dirOf(APP), PackageManager.datasourcePackageName, "${className}Datasource".asKt())

  createRepository(className = className)
    .save(pfm.dirOf(APP), PackageManager.repositoryPackageName, "${className}Repository".asKt())

  createIDatasource(className = className)
    .save(pfm.dirOf(APP), PackageManager.repositoryPackageName, "I${className}Datasource".asKt())

  createUsecase(className = className)
    .save(pfm.dirOf(APP), PackageManager.domainPackageName, "${className}Usecase".asKt())

  createIRepository(className = className)
    .save(pfm.dirOf(APP), PackageManager.domainPackageName, "I${className}Repository".asKt())
}