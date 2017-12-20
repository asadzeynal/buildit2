package az.pkg.buildit.controller;

import az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub;
import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.rmi.RemoteException;

@Controller
public class PurchaseOrderController {
    @RequestMapping(method = RequestMethod.GET, value = "/po/get")
    public String getPurchaseOrderById(@RequestParam String poId, Model model){
        az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.GetPurchaseOrderByIDE stub
                = new az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.GetPurchaseOrderByIDE();
        PurchaseOrderWSServiceStub.PurchaseOrder purchaseOrder = null;
        stub.setGetPurchaseOrderByID(new PurchaseOrderWSServiceStub.GetPurchaseOrderByID());
        stub.getGetPurchaseOrderByID().setArg0(Long.parseLong(poId));
        PurchaseOrderWSServiceStub s = null;
        boolean success = false;
        try {
            s = new PurchaseOrderWSServiceStub();
            purchaseOrder = s.getPurchaseOrderByID(stub).getGetPurchaseOrderByIDResponse().get_return();
            if (purchaseOrder != null) success = true;
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (success) {
            model.addAttribute("po", purchaseOrder);
            return "pos";
        }
        else return "error";

    }
}
