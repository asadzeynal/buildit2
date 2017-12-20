/**
 * PurchaseOrderWSServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package az.pkg.buildit.wsclient;


/**3
 *  PurchaseOrderWSServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class PurchaseOrderWSServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public PurchaseOrderWSServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public PurchaseOrderWSServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for createPurchaseOrder method
     * override this method for handling normal response from createPurchaseOrder operation
     */
    public void receiveResultcreatePurchaseOrder(
        az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.CreatePurchaseOrderResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createPurchaseOrder operation
     */
    public void receiveErrorcreatePurchaseOrder(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getPurchaseOrderByID method
     * override this method for handling normal response from getPurchaseOrderByID operation
     */
    public void receiveResultgetPurchaseOrderByID(
        az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.GetPurchaseOrderByIDResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getPurchaseOrderByID operation
     */
    public void receiveErrorgetPurchaseOrderByID(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for cancelPurchaseOrderById method
     * override this method for handling normal response from cancelPurchaseOrderById operation
     */
    public void receiveResultcancelPurchaseOrderById(
        az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.CancelPurchaseOrderByIdResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from cancelPurchaseOrderById operation
     */
    public void receiveErrorcancelPurchaseOrderById(java.lang.Exception e) {
    }
}
