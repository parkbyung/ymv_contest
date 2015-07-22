package org.log5j.ymv.controller;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
/**
 * 
 * @작성자 : 임영학
 * @내용 : 인터셉터를 사용하여 로그인체크를 할 때 사용하기 위하여 생성한 어노테이션
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoLoginCheck {
   
}