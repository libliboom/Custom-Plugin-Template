package com.github.libliboom.customplugintemplate.manager

import com.github.libliboom.customplugintemplate.manager.Path.DATASOURCE
import com.github.libliboom.customplugintemplate.manager.Path.DOMAIN
import com.github.libliboom.customplugintemplate.manager.Path.PRESENTATION
import com.github.libliboom.customplugintemplate.manager.Path.REPOSITORY

fun addPackageName(packageName: String, applicationPackageName: String) =
  PackageManager.setPackageName(packageName, applicationPackageName)

object PackageManager {

  private var _packageName: String = ""
  val packageName by lazy { _packageName }

  private var _applicationPackageName: String = ""
  val applicationPackageName by lazy { _applicationPackageName }

  val presentationPackageName by lazy { toModulePackageName(PRESENTATION.name)}
  val datasourcePackageName by lazy { toModulePackageName("data.${DATASOURCE.name}")}
  val repositoryPackageName by lazy { toModulePackageName("data.${REPOSITORY.name}")}
  val domainPackageName by lazy { toModulePackageName(DOMAIN.name)}

  fun setPackageName(packageName: String, applicationPackageName: String) {
    this._packageName = packageName
    this._applicationPackageName = applicationPackageName
  }

  private fun toModulePackageName(moduleName: String): String {
    return _packageName
      .replace("ui", "")
      .split(".").let {
        val pre = it.subList(0, it.lastIndex - 1)
        val mid = listOf(moduleName.toLowerCase())
        val last = it.last()
        (pre + mid + last).joinToString(".")
      }
  }
}