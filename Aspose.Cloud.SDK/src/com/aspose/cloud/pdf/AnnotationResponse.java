/**
 * 
 */
package com.aspose.cloud.pdf;

/**
 * @author Mudassir
 *
 */
/// <summary>
/// represents response of a single annotation
/// </summary>

public class AnnotationResponse extends com.aspose.cloud.common.BaseResponse

{
 public AnnotationResponse() { }

// public Annotation  Annotation;
 private Annotation  annotation;

 public Annotation getAnnotation(){return annotation;}
 public void setAnnotation(Annotation _annotation){ annotation=_annotation;}
 
}