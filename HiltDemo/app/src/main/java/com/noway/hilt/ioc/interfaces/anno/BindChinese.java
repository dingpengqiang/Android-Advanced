package com.noway.hilt.ioc.interfaces.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 限定符Qualifier
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface BindChinese {}
