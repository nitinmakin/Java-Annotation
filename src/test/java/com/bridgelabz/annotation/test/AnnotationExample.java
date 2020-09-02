package com.bridgelabz.annotation.test;

import com.bridgelabz.annotation.main.IMethodInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @IMethodInfo(author = "Nitin",comments="Main Method",date="sept 2 2020",revision=1)
    public String toString(){
        return "Overridden toString Method";
    }
    @Deprecated
    @IMethodInfo(author = "Nitin", comments = "deprecated method", date = "sept 2 2020", revision =1 )
    public static void oldMethod(){
        System.out.println("old method,don't use it");
    }

    public static void main(String[] args) {
        try{
            for (Method method:AnnotationExample.class.getMethods()){
                //check if method annotation is present for the method
                if(method.isAnnotationPresent(IMethodInfo.class)) {
                    try {
                        //iterates all the annotation present in the methods
                        for (Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "':" + annotation);
                        }
                        IMethodInfo methodAnnotation=method.getAnnotation(IMethodInfo.class);
                        if(methodAnnotation.revision()==1){
                            System.out.println("Method with revision no 1="+method);
                        }
                    }catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
}