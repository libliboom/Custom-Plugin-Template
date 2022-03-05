package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createDatasource(
  datasourcePackageName: String = PackageManager.datasourcePackageName,
  repositoryPackageName: String = PackageManager.repositoryPackageName,
  className: String
) = """
  package $datasourcePackageName
  
  import $repositoryPackageName.I${className}Datasource
  
  class ${className}Datasource : I${className}Datasource {
  
  }
""".trimIndent()