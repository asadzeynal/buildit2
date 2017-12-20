/**
 * PlantWSServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package az.pkg.buildit.wsclient;


import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.FaultMapKey;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Stub;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.databinding.ADBDataSource;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.databinding.utils.ConverterUtil;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.description.WSDL2Constants;
import org.apache.axis2.util.CallbackReceiver;
import org.apache.axis2.util.Utils;
import org.apache.axis2.wsdl.WSDLConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/*
 *  PlantWSServiceStub java implementation
 */
public class PlantWSServiceStub extends Stub {
    private static int counter = 0;
    protected AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private HashMap faultExceptionNameMap = new HashMap();
    private HashMap faultExceptionClassNameMap = new HashMap();
    private HashMap faultMessageMap = new HashMap();
    private QName[] opNameArray = null;

    /**
     *Constructor that takes in a configContext
     */
    public PlantWSServiceStub(
        ConfigurationContext configurationContext,
        String targetEndpoint) throws AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public PlantWSServiceStub(
        ConfigurationContext configurationContext,
        String targetEndpoint, boolean useSeparateListener)
        throws AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new ServiceClient(configurationContext,
                _service);

        _serviceClient.getOptions()
                      .setTo(new EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    /**
     * Default Constructor
     */
    public PlantWSServiceStub(
        ConfigurationContext configurationContext)
        throws AxisFault {
        this(configurationContext,
            "http://localhost:9000/services/az/pkg/rentit/webservice/PlantWS");
    }

    /**
     * Default Constructor
     */
    public PlantWSServiceStub() throws AxisFault {
        this("http://localhost:9000/services/az/pkg/rentit/webservice/PlantWS");
    }

    /**
     * Constructor taking the target endpoint
     */
    public PlantWSServiceStub(String targetEndpoint)
        throws AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return Long.toString(System.currentTimeMillis()) +
        "_" + counter;
    }

    private void populateAxisService() throws AxisFault {
        //creating the Service with a unique name
        _service = new AxisService(
                "PlantWSService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        AxisOperation __operation;

        _operations = new AxisOperation[2];

        __operation = new OutInAxisOperation();

        __operation.setName(new QName(
                "http://webservice.rentit.pkg.az/", "listAllPlants"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new QName(
                "http://webservice.rentit.pkg.az/", "getPlantByID"));
        _service.addOperation(__operation);

        _operations[1] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @see az.pkg.buildit.wsclient.PlantWSService#listAllPlants
     * @param listAllPlants0
     */
    public PlantWSServiceStub.ListAllPlantsResponseE listAllPlants(
        PlantWSServiceStub.ListAllPlantsE listAllPlants0)
        throws RemoteException {
        MessageContext _messageContext = new MessageContext();

        try {
            OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions()
                            .setAction("http://webservice.rentit.pkg.az/PlantWS/listAllPlantsRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create SOAP envelope with that payload
            SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    listAllPlants0,
                    optimizeContent(
                        new QName(
                            "http://webservice.rentit.pkg.az/", "listAllPlants")),
                    new QName(
                        "http://webservice.rentit.pkg.az/", "listAllPlants"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            MessageContext _returnMessageContext = _operationClient.getMessageContext(WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    PlantWSServiceStub.ListAllPlantsResponseE.class);

            return (PlantWSServiceStub.ListAllPlantsResponseE) object;
        } catch (AxisFault f) {
            OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new FaultMapKey(
                                faultElt.getQName(), "listAllPlants"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                    faultElt.getQName(), "listAllPlants"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                    faultElt.getQName(), "listAllPlants"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass);
                        Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                               .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see az.pkg.buildit.wsclient.PlantWSService#startlistAllPlants
     * @param listAllPlants0
     */
    public void startlistAllPlants(
        PlantWSServiceStub.ListAllPlantsE listAllPlants0,
        final PlantWSServiceCallbackHandler callback)
        throws RemoteException {
        OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions()
                        .setAction("http://webservice.rentit.pkg.az/PlantWS/listAllPlantsRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
            WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
            "&");

        // create SOAP envelope with that payload
        SOAPEnvelope env = null;
        final MessageContext _messageContext = new MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                                                    .getSoapVersionURI()),
                listAllPlants0,
                optimizeContent(
                    new QName(
                        "http://webservice.rentit.pkg.az/", "listAllPlants")),
                new QName(
                    "http://webservice.rentit.pkg.az/", "listAllPlants"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new AxisCallback() {
                public void onMessage(
                    MessageContext resultContext) {
                    try {
                        SOAPEnvelope resultEnv = resultContext.getEnvelope();

                        Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                PlantWSServiceStub.ListAllPlantsResponseE.class);
                        callback.receiveResultlistAllPlants((PlantWSServiceStub.ListAllPlantsResponseE) object);
                    } catch (AxisFault e) {
                        callback.receiveErrorlistAllPlants(e);
                    }
                }

                public void onError(Exception error) {
                    if (error instanceof AxisFault) {
                        AxisFault f = (AxisFault) error;
                        OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new FaultMapKey(
                                            faultElt.getQName(), "listAllPlants"))) {
                                //make the fault by reflection
                                try {
                                    String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                                faultElt.getQName(),
                                                "listAllPlants"));
                                    Class exceptionClass = Class.forName(exceptionClassName);
                                    Constructor constructor = exceptionClass.getConstructor(String.class);
                                    Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                                faultElt.getQName(),
                                                "listAllPlants"));
                                    Class messageClass = Class.forName(messageClassName);
                                    Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    Method m = exceptionClass.getMethod("setFaultMessage",
                                            new Class[] { messageClass });
                                    m.invoke(ex,
                                        new Object[] { messageObject });

                                    callback.receiveErrorlistAllPlants(new RemoteException(
                                            ex.getMessage(), ex));
                                } catch (ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorlistAllPlants(f);
                                } catch (ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorlistAllPlants(f);
                                } catch (NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorlistAllPlants(f);
                                } catch (InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorlistAllPlants(f);
                                } catch (IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorlistAllPlants(f);
                                } catch (InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorlistAllPlants(f);
                                } catch (AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorlistAllPlants(f);
                                }
                            } else {
                                callback.receiveErrorlistAllPlants(f);
                            }
                        } else {
                            callback.receiveErrorlistAllPlants(f);
                        }
                    } else {
                        callback.receiveErrorlistAllPlants(error);
                    }
                }

                public void onFault(
                    MessageContext faultContext) {
                    AxisFault fault = Utils.getInboundFaultFromMessageContext(faultContext);
                    onError(fault);
                }

                public void onComplete() {
                    try {
                        _messageContext.getTransportOut().getSender()
                                       .cleanup(_messageContext);
                    } catch (AxisFault axisFault) {
                        callback.receiveErrorlistAllPlants(axisFault);
                    }
                }
            });

        CallbackReceiver _callbackReceiver = null;

        if ((_operations[0].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new CallbackReceiver();
            _operations[0].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see az.pkg.buildit.wsclient.PlantWSService#getPlantByID
     * @param getPlantByID2
     */
    public PlantWSServiceStub.GetPlantByIDResponseE getPlantByID(
        PlantWSServiceStub.GetPlantByIDE getPlantByID2)
        throws RemoteException {
        MessageContext _messageContext = new MessageContext();

        try {
            OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions()
                            .setAction("http://webservice.rentit.pkg.az/PlantWS/getPlantByIDRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create SOAP envelope with that payload
            SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    getPlantByID2,
                    optimizeContent(
                        new QName(
                            "http://webservice.rentit.pkg.az/", "getPlantByID")),
                    new QName(
                        "http://webservice.rentit.pkg.az/", "getPlantByID"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            MessageContext _returnMessageContext = _operationClient.getMessageContext(WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    PlantWSServiceStub.GetPlantByIDResponseE.class);

            return (PlantWSServiceStub.GetPlantByIDResponseE) object;
        } catch (AxisFault f) {
            OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new FaultMapKey(
                                faultElt.getQName(), "getPlantByID"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                    faultElt.getQName(), "getPlantByID"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                    faultElt.getQName(), "getPlantByID"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass);
                        Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                               .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see az.pkg.buildit.wsclient.PlantWSService#startgetPlantByID
     * @param getPlantByID2
     */
    public void startgetPlantByID(
        PlantWSServiceStub.GetPlantByIDE getPlantByID2,
        final PlantWSServiceCallbackHandler callback)
        throws RemoteException {
        OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
        _operationClient.getOptions()
                        .setAction("http://webservice.rentit.pkg.az/PlantWS/getPlantByIDRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
            WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
            "&");

        // create SOAP envelope with that payload
        SOAPEnvelope env = null;
        final MessageContext _messageContext = new MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                                                    .getSoapVersionURI()),
                getPlantByID2,
                optimizeContent(
                    new QName(
                        "http://webservice.rentit.pkg.az/", "getPlantByID")),
                new QName(
                    "http://webservice.rentit.pkg.az/", "getPlantByID"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new AxisCallback() {
                public void onMessage(
                    MessageContext resultContext) {
                    try {
                        SOAPEnvelope resultEnv = resultContext.getEnvelope();

                        Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                PlantWSServiceStub.GetPlantByIDResponseE.class);
                        callback.receiveResultgetPlantByID((PlantWSServiceStub.GetPlantByIDResponseE) object);
                    } catch (AxisFault e) {
                        callback.receiveErrorgetPlantByID(e);
                    }
                }

                public void onError(Exception error) {
                    if (error instanceof AxisFault) {
                        AxisFault f = (AxisFault) error;
                        OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new FaultMapKey(
                                            faultElt.getQName(), "getPlantByID"))) {
                                //make the fault by reflection
                                try {
                                    String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                                faultElt.getQName(),
                                                "getPlantByID"));
                                    Class exceptionClass = Class.forName(exceptionClassName);
                                    Constructor constructor = exceptionClass.getConstructor(String.class);
                                    Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                                faultElt.getQName(),
                                                "getPlantByID"));
                                    Class messageClass = Class.forName(messageClassName);
                                    Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    Method m = exceptionClass.getMethod("setFaultMessage",
                                            new Class[] { messageClass });
                                    m.invoke(ex,
                                        new Object[] { messageObject });

                                    callback.receiveErrorgetPlantByID(new RemoteException(
                                            ex.getMessage(), ex));
                                } catch (ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorgetPlantByID(f);
                                } catch (ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorgetPlantByID(f);
                                } catch (NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorgetPlantByID(f);
                                } catch (InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorgetPlantByID(f);
                                } catch (IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorgetPlantByID(f);
                                } catch (InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorgetPlantByID(f);
                                } catch (AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorgetPlantByID(f);
                                }
                            } else {
                                callback.receiveErrorgetPlantByID(f);
                            }
                        } else {
                            callback.receiveErrorgetPlantByID(f);
                        }
                    } else {
                        callback.receiveErrorgetPlantByID(error);
                    }
                }

                public void onFault(
                    MessageContext faultContext) {
                    AxisFault fault = Utils.getInboundFaultFromMessageContext(faultContext);
                    onError(fault);
                }

                public void onComplete() {
                    try {
                        _messageContext.getTransportOut().getSender()
                                       .cleanup(_messageContext);
                    } catch (AxisFault axisFault) {
                        callback.receiveErrorgetPlantByID(axisFault);
                    }
                }
            });

        CallbackReceiver _callbackReceiver = null;

        if ((_operations[1].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new CallbackReceiver();
            _operations[1].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    private boolean optimizeContent(QName opName) {
        if (opNameArray == null) {
            return false;
        }

        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }

        return false;
    }

    private OMElement toOM(
        PlantWSServiceStub.ListAllPlantsE param,
        boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(PlantWSServiceStub.ListAllPlantsE.MY_QNAME,
                OMAbstractFactory.getOMFactory());
        } catch (ADBException e) {
            throw AxisFault.makeFault(e);
        }
    }

    private OMElement toOM(
        PlantWSServiceStub.ListAllPlantsResponseE param,
        boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(PlantWSServiceStub.ListAllPlantsResponseE.MY_QNAME,
                OMAbstractFactory.getOMFactory());
        } catch (ADBException e) {
            throw AxisFault.makeFault(e);
        }
    }

    private OMElement toOM(
        PlantWSServiceStub.GetPlantByIDE param,
        boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(PlantWSServiceStub.GetPlantByIDE.MY_QNAME,
                OMAbstractFactory.getOMFactory());
        } catch (ADBException e) {
            throw AxisFault.makeFault(e);
        }
    }

    private OMElement toOM(
        PlantWSServiceStub.GetPlantByIDResponseE param,
        boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(PlantWSServiceStub.GetPlantByIDResponseE.MY_QNAME,
                OMAbstractFactory.getOMFactory());
        } catch (ADBException e) {
            throw AxisFault.makeFault(e);
        }
    }

    private SOAPEnvelope toEnvelope(
        SOAPFactory factory,
        PlantWSServiceStub.ListAllPlantsE param,
        boolean optimizeContent, QName elementQName)
        throws AxisFault {
        try {
            SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    PlantWSServiceStub.ListAllPlantsE.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (ADBException e) {
            throw AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private SOAPEnvelope toEnvelope(
        SOAPFactory factory,
        PlantWSServiceStub.GetPlantByIDE param,
        boolean optimizeContent, QName elementQName)
        throws AxisFault {
        try {
            SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    PlantWSServiceStub.GetPlantByIDE.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (ADBException e) {
            throw AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */

    /**
     *  get the default envelope
     */
    private SOAPEnvelope toEnvelope(
        SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private Object fromOM(OMElement param,
        Class type) throws AxisFault {
        try {
            if (PlantWSServiceStub.GetPlantByIDE.class.equals(
                        type)) {
                return PlantWSServiceStub.GetPlantByIDE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (PlantWSServiceStub.GetPlantByIDResponseE.class.equals(
                        type)) {
                return PlantWSServiceStub.GetPlantByIDResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (PlantWSServiceStub.ListAllPlantsE.class.equals(
                        type)) {
                return PlantWSServiceStub.ListAllPlantsE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (PlantWSServiceStub.ListAllPlantsResponseE.class.equals(
                        type)) {
                return PlantWSServiceStub.ListAllPlantsResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (Exception e) {
            throw AxisFault.makeFault(e);
        }

        return null;
    }

    //http://localhost:9000/services/az/pkg/rentit/webservice/PlantWS
    public static class GetPlantByIDResponse implements ADBBean {
        /* This type was generated from the piece of schema that had
           name = getPlantByIDResponse
           Namespace URI = http://webservice.rentit.pkg.az/
           Namespace Prefix = ns1
         */

        /**
         * field for _return
         */
        protected Plant local_return;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean local_returnTracker = false;

        public boolean is_returnSpecified() {
            return local_returnTracker;
        }

        /**
         * Auto generated getter method
         * @return Plant
         */
        public Plant get_return() {
            return local_return;
        }

        /**
         * Auto generated setter method
         * @param param _return
         */
        public void set_return(Plant param) {
            local_returnTracker = param != null;

            this.local_return = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":getPlantByIDResponse", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "getPlantByIDResponse", xmlWriter);
                }
            }

            if (local_returnTracker) {
                if (local_return == null) {
                    throw new ADBException(
                        "return cannot be null!!");
                }

                local_return.serialize(new QName("",
                        "return"), xmlWriter);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetPlantByIDResponse parse(
                XMLStreamReader reader)
                throws Exception {
                GetPlantByIDResponse object = new GetPlantByIDResponse();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"getPlantByIDResponse".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (GetPlantByIDResponse) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "return").equals(
                                reader.getName())) {
                        object.set_return(Plant.Factory.parse(reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class Plant implements ADBBean {
        /* This type was generated from the piece of schema that had
           name = plant
           Namespace URI = http://webservice.rentit.pkg.az/
           Namespace Prefix = ns1
         */

        /**
         * field for CurrentStatus
         */
        protected PlantStatus localCurrentStatus;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localCurrentStatusTracker = false;

        /**
         * field for Description
         */
        protected String localDescription;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localDescriptionTracker = false;

        /**
         * field for Id
         */
        protected long localId;

        /**
         * field for Name
         */
        protected String localName;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localNameTracker = false;

        /**
         * field for Pos
         * This was an Array!
         */
        protected PurchaseOrder[] localPos;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localPosTracker = false;

        /**
         * field for Price
         */
        protected double localPrice;

        public boolean isCurrentStatusSpecified() {
            return localCurrentStatusTracker;
        }

        /**
         * Auto generated getter method
         * @return PlantStatus
         */
        public PlantStatus getCurrentStatus() {
            return localCurrentStatus;
        }

        /**
         * Auto generated setter method
         * @param param CurrentStatus
         */
        public void setCurrentStatus(PlantStatus param) {
            localCurrentStatusTracker = param != null;

            this.localCurrentStatus = param;
        }

        public boolean isDescriptionSpecified() {
            return localDescriptionTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getDescription() {
            return localDescription;
        }

        /**
         * Auto generated setter method
         * @param param Description
         */
        public void setDescription(String param) {
            localDescriptionTracker = param != null;

            this.localDescription = param;
        }

        /**
         * Auto generated getter method
         * @return long
         */
        public long getId() {
            return localId;
        }

        /**
         * Auto generated setter method
         * @param param Id
         */
        public void setId(long param) {
            this.localId = param;
        }

        public boolean isNameSpecified() {
            return localNameTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getName() {
            return localName;
        }

        /**
         * Auto generated setter method
         * @param param Name
         */
        public void setName(String param) {
            localNameTracker = param != null;

            this.localName = param;
        }

        public boolean isPosSpecified() {
            return localPosTracker;
        }

        /**
         * Auto generated getter method
         * @return PurchaseOrder[]
         */
        public PurchaseOrder[] getPos() {
            return localPos;
        }

        /**
         * validate the array for Pos
         */
        protected void validatePos(PurchaseOrder[] param) {
        }

        /**
         * Auto generated setter method
         * @param param Pos
         */
        public void setPos(PurchaseOrder[] param) {
            validatePos(param);

            localPosTracker = true;

            this.localPos = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param PurchaseOrder
         */
        public void addPos(PurchaseOrder param) {
            if (localPos == null) {
                localPos = new PurchaseOrder[] {  };
            }

            //update the setting tracker
            localPosTracker = true;

            List list = ConverterUtil.toList(localPos);
            list.add(param);
            this.localPos = (PurchaseOrder[]) list.toArray(new PurchaseOrder[list.size()]);
        }

        /**
         * Auto generated getter method
         * @return double
         */
        public double getPrice() {
            return localPrice;
        }

        /**
         * Auto generated setter method
         * @param param Price
         */
        public void setPrice(double param) {
            this.localPrice = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":plant", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "plant", xmlWriter);
                }
            }

            if (localCurrentStatusTracker) {
                if (localCurrentStatus == null) {
                    throw new ADBException(
                        "currentStatus cannot be null!!");
                }

                localCurrentStatus.serialize(new QName("",
                        "currentStatus"), xmlWriter);
            }

            if (localDescriptionTracker) {
                namespace = "";
                writeStartElement(null, namespace, "description", xmlWriter);

                if (localDescription == null) {
                    // write the nil attribute
                    throw new ADBException(
                        "description cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localDescription);
                }

                xmlWriter.writeEndElement();
            }

            namespace = "";
            writeStartElement(null, namespace, "id", xmlWriter);

            if (localId == Long.MIN_VALUE) {
                throw new ADBException(
                    "id cannot be null!!");
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        localId));
            }

            xmlWriter.writeEndElement();

            if (localNameTracker) {
                namespace = "";
                writeStartElement(null, namespace, "name", xmlWriter);

                if (localName == null) {
                    // write the nil attribute
                    throw new ADBException(
                        "name cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localName);
                }

                xmlWriter.writeEndElement();
            }

            if (localPosTracker) {
                if (localPos != null) {
                    for (int i = 0; i < localPos.length; i++) {
                        if (localPos[i] != null) {
                            localPos[i].serialize(new QName(
                                    "", "pos"), xmlWriter);
                        } else {
                            writeStartElement(null, "", "pos", xmlWriter);

                            // write the nil attribute
                            writeAttribute("xsi",
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();
                        }
                    }
                } else {
                    writeStartElement(null, "", "pos", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "nil",
                        "1", xmlWriter);
                    xmlWriter.writeEndElement();
                }
            }

            namespace = "";
            writeStartElement(null, namespace, "price", xmlWriter);

            if (Double.isNaN(localPrice)) {
                throw new ADBException(
                    "price cannot be null!!");
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        localPrice));
            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Plant parse(XMLStreamReader reader)
                throws Exception {
                Plant object = new Plant();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"plant".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (Plant) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    reader.next();

                    ArrayList list5 = new ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "currentStatus").equals(
                                reader.getName())) {
                        object.setCurrentStatus(PlantStatus.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "description").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "description" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setDescription(ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "id").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "id" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setId(ConverterUtil.convertToLong(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "name").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "name" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setName(ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "pos").equals(
                                reader.getName())) {
                        // Process the array and step past its final element's end.
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            list5.add(null);
                            reader.next();
                        } else {
                            list5.add(PurchaseOrder.Factory.parse(reader));
                        }

                        //loop until we find a start element that is not part of this array
                        boolean loopDone5 = false;

                        while (!loopDone5) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();

                            // Step out of this element
                            reader.next();

                            // Step to next element event.
                            while (!reader.isStartElement() &&
                                    !reader.isEndElement())
                                reader.next();

                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone5 = true;
                            } else {
                                if (new QName("", "pos").equals(
                                            reader.getName())) {
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                            "nil");

                                    if ("true".equals(nillableValue) ||
                                            "1".equals(nillableValue)) {
                                        list5.add(null);
                                        reader.next();
                                    } else {
                                        list5.add(PurchaseOrder.Factory.parse(
                                                reader));
                                    }
                                } else {
                                    loopDone5 = true;
                                }
                            }
                        }

                        // call the converter utility  to convert and set the array
                        object.setPos((PurchaseOrder[]) ConverterUtil.convertToArray(
                                PurchaseOrder.class, list5));
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "price").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "price" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setPrice(ConverterUtil.convertToDouble(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class GetPlantByIDE implements ADBBean {
        public static final QName MY_QNAME = new QName("http://webservice.rentit.pkg.az/",
                "getPlantByID", "ns1");

        /**
         * field for GetPlantByID
         */
        protected GetPlantByID localGetPlantByID;

        /**
         * Auto generated getter method
         * @return GetPlantByID
         */
        public GetPlantByID getGetPlantByID() {
            return localGetPlantByID;
        }

        /**
         * Auto generated setter method
         * @param param GetPlantByID
         */
        public void setGetPlantByID(GetPlantByID param) {
            this.localGetPlantByID = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            //We can safely assume an element has only one type associated with it
            if (localGetPlantByID == null) {
                throw new ADBException(
                    "getPlantByID cannot be null!");
            }

            localGetPlantByID.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetPlantByIDE parse(
                XMLStreamReader reader)
                throws Exception {
                GetPlantByIDE object = new GetPlantByIDE();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new QName(
                                        "http://webservice.rentit.pkg.az/",
                                        "getPlantByID").equals(reader.getName())) {
                                object.setGetPlantByID(GetPlantByID.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // 3 - A start element we are not expecting indicates an invalid parameter was passed
                                throw new ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class PlantStatus implements ADBBean {
        public static final QName MY_QNAME = new QName("http://webservice.rentit.pkg.az/",
                "plantStatus", "ns1");
        private static HashMap _table_ = new HashMap();
        public static final String _available = ConverterUtil.convertToString(
                "available");
        public static final String _notAvailable = ConverterUtil.convertToString(
                "notAvailable");
        public static final PlantStatus available = new PlantStatus(_available,
                true);
        public static final PlantStatus notAvailable = new PlantStatus(_notAvailable,
                true);

        /**
         * field for PlantStatus
         */
        protected String localPlantStatus;

        // Constructor
        protected PlantStatus(String value, boolean isRegisterValue) {
            localPlantStatus = value;

            if (isRegisterValue) {
                _table_.put(localPlantStatus, this);
            }
        }

        public String getValue() {
            return localPlantStatus;
        }

        public boolean equals(Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public String toString() {
            return localPlantStatus.toString();
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            //We can safely assume an element has only one type associated with it
            String namespace = parentQName.getNamespaceURI();
            String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":plantStatus", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "plantStatus", xmlWriter);
                }
            }

            if (localPlantStatus == null) {
                throw new ADBException(
                    "plantStatus cannot be null !!");
            } else {
                xmlWriter.writeCharacters(localPlantStatus);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            public static PlantStatus fromValue(String value)
                throws IllegalArgumentException {
                PlantStatus enumeration = (PlantStatus) _table_.get(value);

                // handle unexpected enumeration values properly
                if (enumeration == null) {
                    throw new IllegalArgumentException();
                }

                return enumeration;
            }

            public static PlantStatus fromString(String value,
                String namespaceURI)
                throws IllegalArgumentException {
                try {
                    return fromValue(ConverterUtil.convertToString(
                            value));
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
            }

            public static PlantStatus fromString(
                XMLStreamReader xmlStreamReader,
                String content) {
                if (content.indexOf(":") > -1) {
                    String prefix = content.substring(0,
                            content.indexOf(":"));
                    String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);

                    return PlantStatus.Factory.fromString(content, namespaceUri);
                } else {
                    return PlantStatus.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static PlantStatus parse(
                XMLStreamReader reader)
                throws Exception {
                PlantStatus object = null;

                // initialize a hash map to keep values
                Map attributeMap = new HashMap();
                List extraAttributeList = new ArrayList<OMAttribute>();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {
                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                    "nil");

                            if ("true".equals(nillableValue) ||
                                    "1".equals(nillableValue)) {
                                throw new ADBException(
                                    "The element: " + "plantStatus" +
                                    "  cannot be null");
                            }

                            String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0,
                                        content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = PlantStatus.Factory.fromString(content,
                                        namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = PlantStatus.Factory.fromString(content,
                                        "");
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class PurchaseOrderStatus implements ADBBean {
        public static final QName MY_QNAME = new QName("http://webservice.rentit.pkg.az/",
                "purchaseOrderStatus", "ns1");
        private static HashMap _table_ = new HashMap();
        public static final String _accepted = ConverterUtil.convertToString(
                "accepted");
        public static final String _rejected = ConverterUtil.convertToString(
                "rejected");
        public static final String _cancelledByCustomer = ConverterUtil.convertToString(
                "cancelledByCustomer");
        public static final PurchaseOrderStatus accepted = new PurchaseOrderStatus(_accepted,
                true);
        public static final PurchaseOrderStatus rejected = new PurchaseOrderStatus(_rejected,
                true);
        public static final PurchaseOrderStatus cancelledByCustomer = new PurchaseOrderStatus(_cancelledByCustomer,
                true);

        /**
         * field for PurchaseOrderStatus
         */
        protected String localPurchaseOrderStatus;

        // Constructor
        protected PurchaseOrderStatus(String value,
            boolean isRegisterValue) {
            localPurchaseOrderStatus = value;

            if (isRegisterValue) {
                _table_.put(localPurchaseOrderStatus, this);
            }
        }

        public String getValue() {
            return localPurchaseOrderStatus;
        }

        public boolean equals(Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public String toString() {
            return localPurchaseOrderStatus.toString();
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            //We can safely assume an element has only one type associated with it
            String namespace = parentQName.getNamespaceURI();
            String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":purchaseOrderStatus", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "purchaseOrderStatus", xmlWriter);
                }
            }

            if (localPurchaseOrderStatus == null) {
                throw new ADBException(
                    "purchaseOrderStatus cannot be null !!");
            } else {
                xmlWriter.writeCharacters(localPurchaseOrderStatus);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            public static PurchaseOrderStatus fromValue(String value)
                throws IllegalArgumentException {
                PurchaseOrderStatus enumeration = (PurchaseOrderStatus) _table_.get(value);

                // handle unexpected enumeration values properly
                if (enumeration == null) {
                    throw new IllegalArgumentException();
                }

                return enumeration;
            }

            public static PurchaseOrderStatus fromString(
                String value, String namespaceURI)
                throws IllegalArgumentException {
                try {
                    return fromValue(ConverterUtil.convertToString(
                            value));
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
            }

            public static PurchaseOrderStatus fromString(
                XMLStreamReader xmlStreamReader,
                String content) {
                if (content.indexOf(":") > -1) {
                    String prefix = content.substring(0,
                            content.indexOf(":"));
                    String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);

                    return PurchaseOrderStatus.Factory.fromString(content,
                        namespaceUri);
                } else {
                    return PurchaseOrderStatus.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static PurchaseOrderStatus parse(
                XMLStreamReader reader)
                throws Exception {
                PurchaseOrderStatus object = null;

                // initialize a hash map to keep values
                Map attributeMap = new HashMap();
                List extraAttributeList = new ArrayList<OMAttribute>();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {
                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                    "nil");

                            if ("true".equals(nillableValue) ||
                                    "1".equals(nillableValue)) {
                                throw new ADBException(
                                    "The element: " + "purchaseOrderStatus" +
                                    "  cannot be null");
                            }

                            String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0,
                                        content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = PurchaseOrderStatus.Factory.fromString(content,
                                        namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = PurchaseOrderStatus.Factory.fromString(content,
                                        "");
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ListAllPlantsE implements ADBBean {
        public static final QName MY_QNAME = new QName("http://webservice.rentit.pkg.az/",
                "listAllPlants", "ns1");

        /**
         * field for ListAllPlants
         */
        protected ListAllPlants localListAllPlants;

        /**
         * Auto generated getter method
         * @return ListAllPlants
         */
        public ListAllPlants getListAllPlants() {
            return localListAllPlants;
        }

        /**
         * Auto generated setter method
         * @param param ListAllPlants
         */
        public void setListAllPlants(ListAllPlants param) {
            this.localListAllPlants = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            //We can safely assume an element has only one type associated with it
            if (localListAllPlants == null) {
                throw new ADBException(
                    "listAllPlants cannot be null!");
            }

            localListAllPlants.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListAllPlantsE parse(
                XMLStreamReader reader)
                throws Exception {
                ListAllPlantsE object = new ListAllPlantsE();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new QName(
                                        "http://webservice.rentit.pkg.az/",
                                        "listAllPlants").equals(
                                        reader.getName())) {
                                object.setListAllPlants(ListAllPlants.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // 3 - A start element we are not expecting indicates an invalid parameter was passed
                                throw new ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ExtensionMapper {
        public static Object getTypeObject(
            String namespaceURI, String typeName,
            XMLStreamReader reader) throws Exception {
            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "listAllPlants".equals(typeName)) {
                return ListAllPlants.Factory.parse(reader);
            }

            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "plantStatus".equals(typeName)) {
                return PlantStatus.Factory.parse(reader);
            }

            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "listAllPlantsResponse".equals(typeName)) {
                return ListAllPlantsResponse.Factory.parse(reader);
            }

            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "plant".equals(typeName)) {
                return Plant.Factory.parse(reader);
            }

            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "getPlantByID".equals(typeName)) {
                return GetPlantByID.Factory.parse(reader);
            }

            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "purchaseOrderStatus".equals(typeName)) {
                return PurchaseOrderStatus.Factory.parse(reader);
            }

            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "purchaseOrder".equals(typeName)) {
                return PurchaseOrder.Factory.parse(reader);
            }

            if ("http://webservice.rentit.pkg.az/".equals(namespaceURI) &&
                    "getPlantByIDResponse".equals(typeName)) {
                return GetPlantByIDResponse.Factory.parse(reader);
            }

            throw new ADBException(
                "Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class ListAllPlantsResponseE implements ADBBean {
        public static final QName MY_QNAME = new QName("http://webservice.rentit.pkg.az/",
                "listAllPlantsResponse", "ns1");

        /**
         * field for ListAllPlantsResponse
         */
        protected ListAllPlantsResponse localListAllPlantsResponse;

        /**
         * Auto generated getter method
         * @return ListAllPlantsResponse
         */
        public ListAllPlantsResponse getListAllPlantsResponse() {
            return localListAllPlantsResponse;
        }

        /**
         * Auto generated setter method
         * @param param ListAllPlantsResponse
         */
        public void setListAllPlantsResponse(ListAllPlantsResponse param) {
            this.localListAllPlantsResponse = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            //We can safely assume an element has only one type associated with it
            if (localListAllPlantsResponse == null) {
                throw new ADBException(
                    "listAllPlantsResponse cannot be null!");
            }

            localListAllPlantsResponse.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListAllPlantsResponseE parse(
                XMLStreamReader reader)
                throws Exception {
                ListAllPlantsResponseE object = new ListAllPlantsResponseE();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new QName(
                                        "http://webservice.rentit.pkg.az/",
                                        "listAllPlantsResponse").equals(
                                        reader.getName())) {
                                object.setListAllPlantsResponse(ListAllPlantsResponse.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // 3 - A start element we are not expecting indicates an invalid parameter was passed
                                throw new ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class PurchaseOrder extends PurchaseOrderWSServiceStub.CreatePurchaseOrderE implements ADBBean {
        /* This type was generated from the piece of schema that had
           name = purchaseOrder
           Namespace URI = http://webservice.rentit.pkg.az/
           Namespace Prefix = ns1
         */

        /**
         * field for Contact
         */
        protected String localContact;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localContactTracker = false;

        /**
         * field for Cost
         */
        protected double localCost;

        /**
         * field for Endr
         */
        protected Calendar localEndr;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localEndrTracker = false;

        /**
         * field for Id
         */
        protected long localId;

        /**
         * field for Plant
         */
        protected Plant localPlant;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localPlantTracker = false;

        /**
         * field for PurchaseOrderStatus
         */
        protected PurchaseOrderStatus localPurchaseOrderStatus;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localPurchaseOrderStatusTracker = false;

        /**
         * field for Start
         */
        protected Calendar localStart;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localStartTracker = false;

        public boolean isContactSpecified() {
            return localContactTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getContact() {
            return localContact;
        }

        /**
         * Auto generated setter method
         * @param param Contact
         */
        public void setContact(String param) {
            localContactTracker = param != null;

            this.localContact = param;
        }

        /**
         * Auto generated getter method
         * @return double
         */
        public double getCost() {
            return localCost;
        }

        /**
         * Auto generated setter method
         * @param param Cost
         */
        public void setCost(double param) {
            this.localCost = param;
        }

        public boolean isEndrSpecified() {
            return localEndrTracker;
        }

        /**
         * Auto generated getter method
         * @return java.util.Calendar
         */
        public Calendar getEndr() {
            return localEndr;
        }

        /**
         * Auto generated setter method
         * @param param Endr
         */
        public void setEndr(Calendar param) {
            localEndrTracker = param != null;

            this.localEndr = param;
        }

        /**
         * Auto generated getter method
         * @return long
         */
        public long getId() {
            return localId;
        }

        /**
         * Auto generated setter method
         * @param param Id
         */
        public void setId(long param) {
            this.localId = param;
        }

        public boolean isPlantSpecified() {
            return localPlantTracker;
        }

        /**
         * Auto generated getter method
         * @return Plant
         */
        public Plant getPlant() {
            return localPlant;
        }

        /**
         * Auto generated setter method
         * @param param Plant
         */
        public void setPlant(Plant param) {
            localPlantTracker = param != null;

            this.localPlant = param;
        }

        public boolean isPurchaseOrderStatusSpecified() {
            return localPurchaseOrderStatusTracker;
        }

        /**
         * Auto generated getter method
         * @return PurchaseOrderStatus
         */
        public PurchaseOrderStatus getPurchaseOrderStatus() {
            return localPurchaseOrderStatus;
        }

        /**
         * Auto generated setter method
         * @param param PurchaseOrderStatus
         */
        public void setPurchaseOrderStatus(PurchaseOrderStatus param) {
            localPurchaseOrderStatusTracker = param != null;

            this.localPurchaseOrderStatus = param;
        }

        public boolean isStartSpecified() {
            return localStartTracker;
        }

        /**
         * Auto generated getter method
         * @return java.util.Calendar
         */
        public Calendar getStart() {
            return localStart;
        }

        /**
         * Auto generated setter method
         * @param param Start
         */
        public void setStart(Calendar param) {
            localStartTracker = param != null;

            this.localStart = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":purchaseOrder", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "purchaseOrder", xmlWriter);
                }
            }

            if (localContactTracker) {
                namespace = "";
                writeStartElement(null, namespace, "contact", xmlWriter);

                if (localContact == null) {
                    // write the nil attribute
                    throw new ADBException(
                        "contact cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localContact);
                }

                xmlWriter.writeEndElement();
            }

            namespace = "";
            writeStartElement(null, namespace, "cost", xmlWriter);

            if (Double.isNaN(localCost)) {
                throw new ADBException(
                    "cost cannot be null!!");
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        localCost));
            }

            xmlWriter.writeEndElement();

            if (localEndrTracker) {
                namespace = "";
                writeStartElement(null, namespace, "endr", xmlWriter);

                if (localEndr == null) {
                    // write the nil attribute
                    throw new ADBException(
                        "endr cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            localEndr));
                }

                xmlWriter.writeEndElement();
            }

            namespace = "";
            writeStartElement(null, namespace, "id", xmlWriter);

            if (localId == Long.MIN_VALUE) {
                throw new ADBException(
                    "id cannot be null!!");
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        localId));
            }

            xmlWriter.writeEndElement();

            if (localPlantTracker) {
                if (localPlant == null) {
                    throw new ADBException(
                        "plant cannot be null!!");
                }

                localPlant.serialize(new QName("", "plant"),
                    xmlWriter);
            }

            if (localPurchaseOrderStatusTracker) {
                if (localPurchaseOrderStatus == null) {
                    throw new ADBException(
                        "purchaseOrderStatus cannot be null!!");
                }

                localPurchaseOrderStatus.serialize(new QName(
                        "", "purchaseOrderStatus"), xmlWriter);
            }

            if (localStartTracker) {
                namespace = "";
                writeStartElement(null, namespace, "start", xmlWriter);

                if (localStart == null) {
                    // write the nil attribute
                    throw new ADBException(
                        "start cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            localStart));
                }

                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static PurchaseOrder parse(
                XMLStreamReader reader)
                throws Exception {
                PurchaseOrder object = new PurchaseOrder();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"purchaseOrder".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (PurchaseOrder) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "contact").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "contact" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setContact(ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "cost").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "cost" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setCost(ConverterUtil.convertToDouble(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "endr").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "endr" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setEndr(ConverterUtil.convertToDateTime(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "id").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "id" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setId(ConverterUtil.convertToLong(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "plant").equals(
                                reader.getName())) {
                        object.setPlant(Plant.Factory.parse(reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("",
                                "purchaseOrderStatus").equals(reader.getName())) {
                        object.setPurchaseOrderStatus(PurchaseOrderStatus.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "start").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "start" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setStart(ConverterUtil.convertToDateTime(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class GetPlantByID implements ADBBean {
        /* This type was generated from the piece of schema that had
           name = getPlantByID
           Namespace URI = http://webservice.rentit.pkg.az/
           Namespace Prefix = ns1
         */

        /**
         * field for Arg0
         */
        protected long localArg0;

        /**
         * Auto generated getter method
         * @return long
         */
        public long getArg0() {
            return localArg0;
        }

        /**
         * Auto generated setter method
         * @param param Arg0
         */
        public void setArg0(long param) {
            this.localArg0 = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":getPlantByID", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "getPlantByID", xmlWriter);
                }
            }

            namespace = "";
            writeStartElement(null, namespace, "arg0", xmlWriter);

            if (localArg0 == Long.MIN_VALUE) {
                throw new ADBException(
                    "arg0 cannot be null!!");
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        localArg0));
            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetPlantByID parse(
                XMLStreamReader reader)
                throws Exception {
                GetPlantByID object = new GetPlantByID();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"getPlantByID".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (GetPlantByID) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "arg0").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new ADBException(
                                "The element: " + "arg0" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setArg0(ConverterUtil.convertToLong(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ListAllPlants implements ADBBean {
        /* This type was generated from the piece of schema that had
           name = listAllPlants
           Namespace URI = http://webservice.rentit.pkg.az/
           Namespace Prefix = ns1
         */

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":listAllPlants", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "listAllPlants", xmlWriter);
                }
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListAllPlants parse(
                XMLStreamReader reader)
                throws Exception {
                ListAllPlants object = new ListAllPlants();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"listAllPlants".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ListAllPlants) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ListAllPlantsResponse implements ADBBean {
        /* This type was generated from the piece of schema that had
           name = listAllPlantsResponse
           Namespace URI = http://webservice.rentit.pkg.az/
           Namespace Prefix = ns1
         */

        /**
         * field for _return
         * This was an Array!
         */
        protected Plant[] local_return;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean local_returnTracker = false;

        public boolean is_returnSpecified() {
            return local_returnTracker;
        }

        /**
         * Auto generated getter method
         * @return Plant[]
         */
        public Plant[] get_return() {
            return local_return;
        }

        /**
         * validate the array for _return
         */
        protected void validate_return(Plant[] param) {
        }

        /**
         * Auto generated setter method
         * @param param _return
         */
        public void set_return(Plant[] param) {
            validate_return(param);

            local_returnTracker = param != null;

            this.local_return = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param Plant
         */
        public void add_return(Plant param) {
            if (local_return == null) {
                local_return = new Plant[] {  };
            }

            //update the setting tracker
            local_returnTracker = true;

            List list = ConverterUtil.toList(local_return);
            list.add(param);
            this.local_return = (Plant[]) list.toArray(new Plant[list.size()]);
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://webservice.rentit.pkg.az/");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":listAllPlantsResponse", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "listAllPlantsResponse", xmlWriter);
                }
            }

            if (local_returnTracker) {
                if (local_return != null) {
                    for (int i = 0; i < local_return.length; i++) {
                        if (local_return[i] != null) {
                            local_return[i].serialize(new QName(
                                    "", "return"), xmlWriter);
                        } else {
                            // we don't have to do any thing since minOccures is zero
                        }
                    }
                } else {
                    throw new ADBException(
                        "return cannot be null!!");
                }
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListAllPlantsResponse parse(
                XMLStreamReader reader)
                throws Exception {
                ListAllPlantsResponse object = new ListAllPlantsResponse();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"listAllPlantsResponse".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ListAllPlantsResponse) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    reader.next();

                    ArrayList list1 = new ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new QName("", "return").equals(
                                reader.getName())) {
                        // Process the array and step past its final element's end.
                        list1.add(Plant.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;

                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();

                            // Step out of this element
                            reader.next();

                            // Step to next element event.
                            while (!reader.isStartElement() &&
                                    !reader.isEndElement())
                                reader.next();

                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new QName("", "return").equals(
                                            reader.getName())) {
                                    list1.add(Plant.Factory.parse(reader));
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }

                        // call the converter utility  to convert and set the array
                        object.set_return((Plant[]) ConverterUtil.convertToArray(
                                Plant.class, list1));
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class GetPlantByIDResponseE implements ADBBean {
        public static final QName MY_QNAME = new QName("http://webservice.rentit.pkg.az/",
                "getPlantByIDResponse", "ns1");

        /**
         * field for GetPlantByIDResponse
         */
        protected GetPlantByIDResponse localGetPlantByIDResponse;

        /**
         * Auto generated getter method
         * @return GetPlantByIDResponse
         */
        public GetPlantByIDResponse getGetPlantByIDResponse() {
            return localGetPlantByIDResponse;
        }

        /**
         * Auto generated setter method
         * @param param GetPlantByIDResponse
         */
        public void setGetPlantByIDResponse(GetPlantByIDResponse param) {
            this.localGetPlantByIDResponse = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public OMElement getOMElement(
            final QName parentQName,
            final OMFactory factory)
            throws ADBException {
            return factory.createOMElement(new ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException,
                ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final QName parentQName,
            XMLStreamWriter xmlWriter, boolean serializeType)
            throws XMLStreamException,
                ADBException {
            //We can safely assume an element has only one type associated with it
            if (localGetPlantByIDResponse == null) {
                throw new ADBException(
                    "getPlantByIDResponse cannot be null!");
            }

            localGetPlantByIDResponse.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://webservice.rentit.pkg.az/")) {
                return "ns1";
            }

            return BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
            String namespace, String localPart,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
            String namespace, String attName,
            String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
            String attName, String attValue,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
            String attName, QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(QName qname,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(QName[] qnames,
            XMLStreamWriter xmlWriter)
            throws XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            XMLStreamWriter xmlWriter,
            String namespace)
            throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static GetPlantByIDResponseE parse(
                XMLStreamReader reader)
                throws Exception {
                GetPlantByIDResponseE object = new GetPlantByIDResponseE();

                int event;
                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    Vector handledAttributes = new Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new QName(
                                        "http://webservice.rentit.pkg.az/",
                                        "getPlantByIDResponse").equals(
                                        reader.getName())) {
                                object.setGetPlantByIDResponse(GetPlantByIDResponse.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // 3 - A start element we are not expecting indicates an invalid parameter was passed
                                throw new ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }
}
