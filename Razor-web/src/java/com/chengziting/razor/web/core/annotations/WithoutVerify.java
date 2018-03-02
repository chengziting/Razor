package com.chengziting.razor.web.core.annotations;

import java.lang.annotation.*;

/**
 * Created by user on 2018-01-16.
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface WithoutVerify {
}