package com.bizvane.mktcenterservice.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 工具自动生成代码配置类
 * 
 * @author 董争光 2018年5月21日下午1:48:07
 */
public class DefaultCommentGenerator implements CommentGenerator {

  /**
   * The properties.
   */
  private Properties properties;

  /**
   * The suppress date.
   */
  private boolean suppressDate;

  /**
   * The suppress all comments.
   */
  private boolean suppressAllComments;

  /**
   * The addition of table remark's comments. If suppressAllComments is true, this option is ignored
   */
  private boolean addRemarkComments;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /**
   * Instantiates a new default comment generator.
   */
  public DefaultCommentGenerator() {
    super();
    this.properties = new Properties();
    this.suppressDate = false;
    this.suppressAllComments = false;
    this.addRemarkComments = true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.mybatis.generator.api.CommentGenerator#addJavaFileComment(org.mybatis.generator.api.dom.
   * java.CompilationUnit)
   */
  @Override
  public void addJavaFileComment(CompilationUnit compilationUnit) {

  }

  /**
   * Adds a suitable comment to warn users that the element was generated, and when it was
   * generated.
   *
   * @param xmlElement the xml element
   */
  @Override
  public void addComment(XmlElement xmlElement) {

    xmlElement.addElement(new TextElement("<!--")); //$NON-NLS-1$

    StringBuilder sb = new StringBuilder();
    sb.append("  WARNING - 只读 - "); //$NON-NLS-1$
    sb.append(MergeConstants.NEW_ELEMENT_TAG);
    xmlElement.addElement(new TextElement(sb.toString()));
    xmlElement.addElement(new TextElement("-->")); //$NON-NLS-1$
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.mybatis.generator.api.CommentGenerator#addRootComment(org.mybatis.generator.api.dom.xml.
   * XmlElement)
   */
  @Override
  public void addRootComment(XmlElement rootElement) {

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.mybatis.generator.api.CommentGenerator#addConfigurationProperties(java.util.Properties)
   */
  @Override
  public void addConfigurationProperties(Properties properties) {
    this.properties.putAll(properties);

    this.suppressDate = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

    this.suppressAllComments =
        StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

    this.addRemarkComments =
        StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

    String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
    if (StringUtility.stringHasValue(dateFormatString)) {
      this.dateFormat = new SimpleDateFormat(dateFormatString);
    }
  }

  /**
   * This method adds the custom javadoc tag for. You may do nothing if you do not wish to include
   * the Javadoc tag - however, if you do not include the Javadoc tag then the Java merge capability
   * of the eclipse plugin will break.
   *
   * @param javaElement the java element
   * @param markAsDoNotDelete the mark as do not delete
   */
  protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
    javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
    StringBuilder sb = new StringBuilder();
    sb.append(" * "); //$NON-NLS-1$
    sb.append(MergeConstants.NEW_ELEMENT_TAG);
    if (markAsDoNotDelete) {
      sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
    }
    javaElement.addJavaDocLine(sb.toString());
  }

  /**
   * This method returns a formated date string to include in the Javadoc tag and XML comments. You
   * may return null if you do not want the date in these documentation elements.
   *
   * @return a string representing the current timestamp, or null
   */
  protected String getDateString() {
    if (this.suppressDate) {
      return null;
    } else if (this.dateFormat != null) {
      return this.dateFormat.format(new Date());
    } else {
      return new Date().toString();
    }
  }

  /**
   * 内部类注释
   */
  @Override
  public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    StringBuilder sb = new StringBuilder();

    innerClass.addJavaDocLine("/**"); //$NON-NLS-1$

    sb.append(" * 只读. "); //$NON-NLS-1$
    sb.append(introspectedTable.getFullyQualifiedTable());
    innerClass.addJavaDocLine(sb.toString());

    this.addJavadocTag(innerClass, false);

    innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
  }

  /**
   * po类注释
   */
  @Override
  public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

    topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModelProperty;");
    topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModel;");
    String swagger = "@ApiModel(\"" + introspectedTable.getRemarks() + "\")";
    topLevelClass.addJavaDocLine(swagger);
    
  }
  
  

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.mybatis.generator.api.CommentGenerator#addEnumComment(org.mybatis.generator.api.dom.java.
   * InnerEnum, org.mybatis.generator.api.IntrospectedTable)
   */
  @Override
  public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    StringBuilder sb = new StringBuilder();

    innerEnum.addJavaDocLine("/**5"); //$NON-NLS-1$
    innerEnum.addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

    sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
    sb.append(introspectedTable.getFullyQualifiedTable());
    innerEnum.addJavaDocLine(sb.toString());

    this.addJavadocTag(innerEnum, false);

    innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
  }

  /**
   * PO字段属性
   */
  @Override
  public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    field.addJavaDocLine("/**@mbg.generated*/");
    
    String remarks = introspectedColumn.getRemarks();
    String swaggerName = field.getName();
    String[] remarksList = remarks.split("示例");
    
    String swaggerValue = remarks;
    String swaggerexample = "";
    
    if (remarksList.length == 2) {
       swaggerValue = remarksList[0];
       swaggerexample = remarksList[1];
    } 

    String swagger = "@ApiModelProperty(value = \"" + swaggerValue + "\","
        + "name = \"" + swaggerName + "\", required = false,"
        + "example = \"" + swaggerexample + "\")";
    field.addJavaDocLine(swagger);
  }

  /**
   * 序列化常量
   */
  @Override
  public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    field.addJavaDocLine("/**@mbg.generated*/");
  }

  /**
   * mapper接口
   */
  @Override
  public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
    if (this.suppressAllComments) {
      return;
    }

    method.addJavaDocLine("/**"); //$NON-NLS-1$
    method.addJavaDocLine(" * 只读. "); //$NON-NLS-1$
    this.addJavadocTag(method, false);

    method.addJavaDocLine(" */"); //$NON-NLS-1$
  }

  /**
   * 属性get方法
   */
  @Override
  public void addGetterComment(Method method, IntrospectedTable introspectedTable,
      IntrospectedColumn introspectedColumn) {

    method.addJavaDocLine("/**@mbg.generated*/");
  }

  /**
   * 属性set方法
   */
  @Override
  public void addSetterComment(Method method, IntrospectedTable introspectedTable,
      IntrospectedColumn introspectedColumn) {

    method.addJavaDocLine("/**@mbg.generated*/");
  }

  /**
   * 内部类使用
   */
  @Override
  public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

    StringBuilder sb = new StringBuilder();

    innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
    innerClass.addJavaDocLine(" * This class was generated by MyBatis Generator."); //$NON-NLS-1$

    sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
    sb.append(introspectedTable.getFullyQualifiedTable());
    innerClass.addJavaDocLine(sb.toString());

    this.addJavadocTag(innerClass, markAsDoNotDelete);

    innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
  }
}
