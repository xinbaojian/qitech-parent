package com.qitech.mybatis.generator.comment;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * @author xinbj
 */
public class MyCommentGenerator implements CommentGenerator {

    private Properties properties;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private boolean addRemarkComments;

    private SimpleDateFormat dateFormat;

    public MyCommentGenerator() {
        super();
        properties = System.getProperties();
        suppressAllComments = false;
        addRemarkComments = false;
    }


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String annotationStr;
        String decimal = "DECIMAL";
        String string = "java.lang.String";
        String date = "java.util.Date";
        String id = "id";
        String notEmptyStr = "Can not be empty";
        String notNullStr = "Can not be null";
        //不为空并且类型是String类型
        if (!introspectedColumn.isNullable() && string.equals(introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName())) {
            annotationStr = String.format("@NotBlank(message = \"%s\")", introspectedColumn.getRemarks() + notEmptyStr);
            if (!introspectedColumn.isIdentity() && !id.equals(introspectedColumn.getActualColumnName())) {
                field.addAnnotation(annotationStr);
            }
        } else if (!introspectedColumn.isNullable()) {
            annotationStr = String.format("@NotNull(message = \"%s\")", introspectedColumn.getRemarks() + notNullStr);
            if (!introspectedColumn.isIdentity() && !id.equals(introspectedColumn.getActualColumnName())) {
                field.addAnnotation(annotationStr);
            }
        }

        if (decimal.equals(introspectedColumn.getJdbcTypeName())) {
            annotationStr = "@Digits(integer=" + introspectedColumn.getLength() + ",fraction=" + introspectedColumn.getScale() + ")";
            field.addAnnotation(annotationStr);
        } else if (string.equals(introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName())) {
            annotationStr = String.format("@Size(max = %s,  message = \" %s max length is %s\")", introspectedColumn.getLength(), introspectedColumn.getRemarks(), introspectedColumn.getLength());
            field.addAnnotation(annotationStr);
        }
        if (date.equals(introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName())) {
        }
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine(" */");

    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments || !addRemarkComments) {
            return;
        }

        String author = properties.getProperty("user.name");
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks);
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

        String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        String example = "Example";
        String mapper = "Mapper";
        if (!compilationUnit.getType().getFullyQualifiedName().contains(example)
        && !compilationUnit.getType().getFullyQualifiedName().contains(mapper)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.validation.constraints.Digits"));
            compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.validation.constraints.Size"));
            compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.validation.constraints.NotNull"));
            compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.validation.constraints.NotBlank"));
        }
    }

    @Override
    public void addComment(XmlElement xmlElement) {

    }

    @Override
    public void addRootComment(XmlElement rootElement) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {

    }
}
