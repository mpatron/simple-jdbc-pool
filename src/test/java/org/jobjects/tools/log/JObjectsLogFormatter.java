package org.jobjects.tools.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class JObjectsLogFormatter extends Formatter {
  public final static String ISO8601DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
  public final static String VERYSMAL = "h:mm:ss";
  private static final DateFormat format = new SimpleDateFormat(ISO8601DATEFORMAT);

  @Override
  public String format(LogRecord record) {
    String loggerName = record.getLoggerName();
    if (loggerName == null) {
      loggerName = "root";
    }
    StringBuilder output = new StringBuilder();
    java.util.Formatter formatter = new java.util.Formatter(output, Locale.FRENCH);
    output.append("[");
    formatter.format("%-7s", record.getLevel());
    formatter.close();
    output.append(" - ");
    // .append(Thread.currentThread().getName()).append('|')
    output.append(format.format(new Date(record.getMillis())));
    output.append("] ");
    output.append(record.getSourceClassName()+"#"+record.getSourceMethodName());
    
    output.append(" : ");

    if (record.getParameters() != null) {
      try {
        output.append(MessageFormat.format(record.getMessage(), record.getParameters()));
      } catch (Throwable t) {
        output.append(record.getMessage());
        output.append("[Internal log error :"+t.getMessage()+"]");
      }
    } else {
      output.append(record.getMessage());
    }

    if (record.getThrown() != null) {
      output.append(System.lineSeparator());
      output.append(stackTraceToString(record.getThrown()));
    }

    output.append(System.lineSeparator());
    return output.toString();
  }

  public String stackTraceToString(Throwable e) {
    String returnValue=null;
    if(null!=e) {
      StringWriter sw = null;
      try {
        sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        returnValue=sw.toString();
        pw.close();
        sw.close();
      } catch (Throwable t) {
        returnValue="Log internal error and " + e.getMessage();
      } 
    }
    return returnValue; 
  }
  
}
