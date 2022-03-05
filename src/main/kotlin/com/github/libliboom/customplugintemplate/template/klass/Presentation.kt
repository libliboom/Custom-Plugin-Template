package com.github.libliboom.customplugintemplate.template.klass

import com.github.libliboom.customplugintemplate.manager.PackageManager

fun createPresentation(
  presentationPackageName: String = PackageManager.presentationPackageName,
  className: String
) = """
  package $presentationPackageName
 
  class ${className}Presentation {
  
  }
""".trimIndent()

fun createAction(
  presentationPackageName: String = PackageManager.presentationPackageName,
  className: String
) = """
  package $presentationPackageName
 
  interface ${className}Action
""".trimIndent()

fun createMiddleware(
  presentationPackageName: String = PackageManager.presentationPackageName,
  className: String
) = """
  package $presentationPackageName
 
  class ${className}Middleware {
  
  }
""".trimIndent()

fun createReducer(
  presentationPackageName: String = PackageManager.presentationPackageName,
  className: String
) = """
  package $presentationPackageName
 
  class ${className}Reducer {
  
  }
""".trimIndent()

fun createViewModel(
  packageName: String = PackageManager.packageName,
  className: String
) = """
  package $packageName
  
  import androidx.lifecycle.ViewModel
 
  data class ${className}ViewState(
   val type: ${className}ViewStateType = ${className}ViewStateType.INIT
  )
  
  enum class ${className}ViewStateType{
   INIT
  }
 
  class ${className}ViewModel : ViewModel() {
  
  }
""".trimIndent()