package com.bridgelabz.annotation.main;

import java.lang.annotation.*;
//weather to put annotation in javadocs
@Documented

//places the annotation can go
@Target(ElementType.METHOD)

//weather subclass get the annotation
@Inherited

//when the annotation is needed
@Retention(RetentionPolicy.RUNTIME)
public @interface IMethodInfo {

    String author() ;
    String date();
    int revision() ;
    String comments();

}
