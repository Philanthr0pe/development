/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2016                                        
 *       
 *  Creation Date: 2011-08-09                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.internal.types.exception;

import org.oscm.internal.types.enumtypes.ServiceStatus;
import org.oscm.internal.types.exception.beans.ApplicationExceptionBean;

/**
 * Exception thrown when an operation cannot be performed due to the current
 * status of a service.
 * 
 */
public class ServiceStateException extends SaaSApplicationException {

    private static final long serialVersionUID = -5017219969472071255L;

    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     * The cause is not initialized.
     */
    public ServiceStateException() {

    }

    /**
     * Constructs a new exception with the specified detail message. The cause
     * is not initialized.
     * 
     * @param message
     *            the detail message
     */
    public ServiceStateException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and bean for
     * JAX-WS exception serialization.
     * 
     * @param message
     *            the detail message
     * @param bean
     *            the bean for JAX-WS exception serialization
     */
    public ServiceStateException(String message, ApplicationExceptionBean bean) {
        super(message, bean);
    }

    /**
     * Constructs a new exception with the specified detail message, cause, and
     * bean for JAX-WS exception serialization.
     * 
     * @param message
     *            the detail message
     * @param bean
     *            the bean for JAX-WS exception serialization
     * @param cause
     *            the cause
     */
    public ServiceStateException(String message, ApplicationExceptionBean bean,
            Throwable cause) {
        super(message, bean, cause);
    }

    /**
     * Constructs a new exception with a pre-defined detail message that
     * includes the given message parameters.
     * 
     * @param expected
     *            the expected status of the service
     * @param current
     *            the actual status of the service
     */
    public ServiceStateException(ServiceStatus expected, ServiceStatus current) {
        super("Service operation tried on a service with invalid status",
                new Object[] { expected.name(), current.name() });
    }

    /**
     * Constructs a new exception with a pre-defined detail message that
     * includes the given message parameters.
     * 
     * @param expected
     *            the expected status of the service
     * @param current
     *            the actual status of the service
     */
    public ServiceStateException(ServiceStatus current, String expected) {
        super("Service operation tried on a service with invalid status",
                new Object[] { expected, current.name() });
    }

    /**
     * Constructs a new exception with a pre-defined detail message that
     * includes the given message parameters.
     * 
     * @param expected
     *            the expected status of the service
     * @param current
     *            the actual status of the service
     * @param serviceId
     *            the identifier of the service with the specified
     *            <code>current</code> status
     */
    public ServiceStateException(ServiceStatus current, String expected,
            String serviceId) {
        super("Service operation tried on the service " + serviceId
                + " with invalid status", new Object[] { expected,
                current.name(), serviceId });
    }

}
