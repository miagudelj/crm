/**
 * hides stacktrace
 */
package ch.zli.m223.ksh18a.mia.crm.exception;

/**
 * 
 * @author Mia Gudelj
 * @since 13-07-2021
 *
 */

@SuppressWarnings("serial")
public class NoStackTraceException extends RuntimeException {

	public NoStackTraceException() {
		super("", null, true, false);
	}

}
