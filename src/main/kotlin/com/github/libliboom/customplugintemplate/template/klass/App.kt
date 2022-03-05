package com.github.libliboom.customplugintemplate.template.klass

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateSimpleLayout
import com.github.libliboom.customplugintemplate.manager.PackageManager
import com.github.libliboom.customplugintemplate.template.utils.toSnakeCase
import com.github.libliboom.customplugintemplate.template.workaround.manifestTemplateXml
import java.io.File

fun RecipeExecutor.createActivity(
  packageName: String = PackageManager.packageName,
  applicationPackageName: String = PackageManager.applicationPackageName,
  className: String,
  manifestOut: File,
  moduleData: ModuleTemplateData
): String {
  val activityClassName = "${className}Activity"
  val layoutFileName = "Activity${className}"
  mergeXml(manifestTemplateXml(packageName, activityClassName), manifestOut.resolve("AndroidManifest.xml"))
  generateSimpleLayout(moduleData, activityClassName, layoutFileName.toSnakeCase())
  return createActivity(packageName, applicationPackageName, className)
}

fun createActivity(
  packageName: String,
  applicationPackageName: String,
  className: String
) = """
  package $packageName
  
  import androidx.activity.viewModels
  import $applicationPackageName.databinding.Activity${className}Binding
  import $applicationPackageName.base.BaseActivity
  
  class ${className}Activity : BaseActivity<Activity${className}Binding>() {
  
    private val viewModels by viewModels<${className}ViewModel>()
  
    override fun inflateBinding() = Activity${className}Binding.inflate(layoutInflater)
    
  }
""".trimIndent()