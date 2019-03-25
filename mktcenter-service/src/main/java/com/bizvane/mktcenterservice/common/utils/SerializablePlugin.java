package com.bizvane.mktcenterservice.common.utils;

import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 工具生成代码PO加上序列化
 * 
 * @author 董争光 2018年5月21日下午1:49:29
 */
public class SerializablePlugin extends PluginAdapter {

  private FullyQualifiedJavaType serializable;
  private FullyQualifiedJavaType gwtSerializable;
  private boolean addGWTInterface;
  private boolean suppressJavaInterface;

  public SerializablePlugin() {
    super();
    this.serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$
    this.gwtSerializable = new FullyQualifiedJavaType("com.google.gwt.user.client.rpc.IsSerializable"); //$NON-NLS-1$
  }

  @Override
  public boolean validate(List<String> warnings) {
    // this plugin is always valid
    return true;
  }

  @Override
  public void setProperties(Properties properties) {
    super.setProperties(properties);
    this.addGWTInterface = Boolean.valueOf(properties.getProperty("addGWTInterface")); //$NON-NLS-1$
    this.suppressJavaInterface = Boolean.valueOf(properties.getProperty("suppressJavaInterface")); //$NON-NLS-1$
  }

  @Override
  public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    this.makeSerializable(topLevelClass, introspectedTable);
    return true;
  }

  @Override
  public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    this.makeSerializable(topLevelClass, introspectedTable);
    return true;
  }

  @Override
  public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    this.makeSerializable(topLevelClass, introspectedTable);
    return true;
  }

  /**
   * 添加给Example类序列化的方法
   *
   * @param topLevelClass
   * @param introspectedTable
   * @return
   */
  @Override
  public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    this.makeSerializable(topLevelClass, introspectedTable);

    for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
      if ("GeneratedCriteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$
        innerClass.addSuperInterface(this.serializable);
      }
      if ("Criteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$
        innerClass.addSuperInterface(this.serializable);
      }
      if ("Criterion".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$
        innerClass.addSuperInterface(this.serializable);
      }
    }

    return true;
  }

  protected void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    if (this.addGWTInterface) {
      topLevelClass.addImportedType(this.gwtSerializable);
      topLevelClass.addSuperInterface(this.gwtSerializable);
    }

    if (!this.suppressJavaInterface) {
      topLevelClass.addImportedType(this.serializable);
      topLevelClass.addSuperInterface(this.serializable);

      Field field = new Field();
      field.setFinal(true);
      field.setInitializationString("1L"); //$NON-NLS-1$
      field.setName("serialVersionUID"); //$NON-NLS-1$
      field.setStatic(true);
      field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$
      field.setVisibility(JavaVisibility.PRIVATE);
      this.context.getCommentGenerator().addFieldComment(field, introspectedTable);

      topLevelClass.addField(field);
    }
  }
}
