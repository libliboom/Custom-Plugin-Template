package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createUsecase(
  domainPackageName: String = PackageManager.domainPackageName,
  className: String
) = """
  package $domainPackageName
 
  class ${className}Usecase(val repository: I${className}Repository) {
  
  }
""".trimIndent()

fun createIRepository(
  domainPackageName: String = PackageManager.domainPackageName,
  className: String
) ="""
  package $domainPackageName
 
  interface I${className}Repository
""".trimIndent()