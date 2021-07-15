/**
 * error warning when user not found
 */
package ch.zli.m223.ksh18a.mia.crm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 *
 */

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User not Found")
public class UserNotFoundException extends NoStackTraceException {

}
