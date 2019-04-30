package com.concretepage.util;

import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class GZIPWriterInterceptor implements WriterInterceptor{

    private HttpHeaders httpHeaders;

    public GZIPWriterInterceptor(@Context @NotNull HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {

        System.out.println(" <<<aroundWriteTo >>>");
        MultivaluedMap<String,Object> headers = context.getHeaders();
        headers.add("Content-Encoding", "gzip");

        final OutputStream outputStream = context.getOutputStream();
        context.setOutputStream(new GZIPOutputStream(outputStream));
        context.proceed();
    }
}
