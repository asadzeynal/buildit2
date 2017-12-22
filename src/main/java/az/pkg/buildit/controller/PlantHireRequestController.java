package az.pkg.buildit.controller;

import az.pkg.buildit.entity.Plant;
import az.pkg.buildit.entity.PlantHireRequest;
import az.pkg.buildit.entity.PlantHireRequestStatus;
import az.pkg.buildit.entity.Role;
import az.pkg.buildit.service.PlantHireRequestService;
import az.pkg.buildit.service.PlantService;
import az.pkg.buildit.wsclient.PlantWSServiceStub;
import az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub;
import org.apache.axis2.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class PlantHireRequestController {

    @Autowired
    PlantHireRequestService service;

    @Autowired
    PlantService plantService;


    @RequestMapping(method = RequestMethod.POST, value = "/phr/reject")
    public String rejectPlantHireRequest(@RequestBody MultiValueMap<String, String> map, HttpSession session, Model model){
        if (!session.getAttribute("role").equals(Role.admin) && !session.getAttribute("role").equals(Role.worksEngineer)){
            model.addAttribute("message", "Your role does not satisfy this request");
            return "error";
        }
        PlantHireRequest phr = service.find(Long.parseLong(map.getFirst("phrId")));
        if (phr.getStatus().equals(PlantHireRequestStatus.sentToSupplier) || phr.getStatus().equals(PlantHireRequestStatus.cancelled)){
            model.addAttribute("message", "You cannot reject this request");
            return "error";
        }
        phr.setStatus(PlantHireRequestStatus.cancelled);
        service.create(phr);
        model.addAttribute("message", "Successfully rejected plant hire request");
        return "success";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/phr/accept")
    public String acceptPlantHireRequest(@RequestBody MultiValueMap<String,String> map, HttpSession session, Model model){
        if (!session.getAttribute("role").equals(Role.admin) && !session.getAttribute("role").equals(Role.worksEngineer)){
            model.addAttribute("message", "Your role does not satisfy this request");
            return "error";
        }
        PlantHireRequest phr = service.find(Long.parseLong(map.getFirst("phrId")));
        az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.CreatePurchaseOrderE stub
                = new az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.CreatePurchaseOrderE();
        PurchaseOrderWSServiceStub.PurchaseOrder purchaseOrder = new PurchaseOrderWSServiceStub.PurchaseOrder();
        purchaseOrder.setContact(phr.getContact());
        purchaseOrder.setCost(phr.getCost());
        Calendar c = Calendar.getInstance();
        c.setTime(phr.getEndr());
        purchaseOrder.setEndr(c);
        c.setTime(phr.getStart());
        purchaseOrder.setStart(c);
        PurchaseOrderWSServiceStub.Plant posplant = new PurchaseOrderWSServiceStub.Plant();
        posplant.setId(phr.getPlant().getId());
        purchaseOrder.setPlant(posplant);
        stub.setCreatePurchaseOrder(new PurchaseOrderWSServiceStub.CreatePurchaseOrder());
        stub.getCreatePurchaseOrder().setArg0(purchaseOrder);
        phr.setStatus(PlantHireRequestStatus.sentToSupplier);
        service.modify(phr);
        PurchaseOrderWSServiceStub s = null;
        boolean success = false;
        try {
            s = new PurchaseOrderWSServiceStub();
            success = s.createPurchaseOrder(stub).getCreatePurchaseOrderResponse().get_return();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (success) {
            model.addAttribute("Success");
            return "success";
        }
        else return "error";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/phr/create")
    public String createPlantHireRequest(@RequestBody MultiValueMap<String,String> map, HttpSession session, Model model) throws RemoteException {
        if (!session.getAttribute("role").equals(Role.admin) && !session.getAttribute("role").equals(Role.siteEngineer)){
            model.addAttribute("message", "Your role does not satisfy this request");
            return "error";
        }
        PlantHireRequest phr = new PlantHireRequest();
        phr.setContact(map.getFirst("contact"));
        PlantWSServiceStub.GetPlantByIDE plantws = new PlantWSServiceStub.GetPlantByIDE();
        plantws.setGetPlantByID(new PlantWSServiceStub.GetPlantByID());
        plantws.getGetPlantByID().setArg0(Long.parseLong(map.getFirst("plantId")));
        PlantWSServiceStub plws = new PlantWSServiceStub();
        PlantWSServiceStub.Plant plant = plws.getPlantByID(plantws).getGetPlantByIDResponse().get_return();
        Plant p  = new Plant();
        p.setId(plant.getId());
        p.setPrice(plant.getPrice());
        p.setName(plant.getName());
        p.setDescription(plant.getDescription());
        plantService.edit(p);
        phr.setPlant(p);
        phr.setContact(session.getAttribute("username").toString());
        phr.setCost(phr.getPlant().getPrice());
        phr.setStart(Date.valueOf(map.getFirst("start")));
        phr.setEndr(Date.valueOf(map.getFirst("end")));
        phr.setStatus(PlantHireRequestStatus.applied);
        service.create(phr);
        model.addAttribute("message", "PlantHireRequest successfully created");
        return "success";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/phr/edit")
    public String editPlantHireRequest(@RequestBody MultiValueMap<String,String> map, HttpSession session, Model model) throws RemoteException {
//        if (!session.getAttribute("role").equals(Role.admin) && !session.getAttribute("role").equals(Role.worksEngineer)){
//            model.addAttribute("message", "Your role does not satisfy this request");
//            return "error";
//        }
        if (service.find(Long.parseLong(map.getFirst("phrId"))).getStatus().equals(PlantHireRequestStatus.sentToSupplier)){
            model.addAttribute("message", "You cannot modify this Plant Hire Request anymore");
            return "error";
        }
        PlantHireRequest phr = new PlantHireRequest();
        phr.setId(Long.parseLong(map.getFirst("phrId")));
        phr.setContact(session.getAttribute("username").toString());
        PlantWSServiceStub.GetPlantByIDE plantws = new PlantWSServiceStub.GetPlantByIDE();
        plantws.setGetPlantByID(new PlantWSServiceStub.GetPlantByID());
        plantws.getGetPlantByID().setArg0(Long.parseLong(map.getFirst("plantId")));
        PlantWSServiceStub plws = new PlantWSServiceStub();
        PlantWSServiceStub.Plant plant = plws.getPlantByID(plantws).getGetPlantByIDResponse().get_return();
        Plant p  = new Plant();
        p.setId(plant.getId());
        p.setPrice(plant.getPrice());
        p.setName(plant.getName());
        p.setDescription(plant.getDescription());
        plantService.edit(p);
        phr.setPlant(p);
        phr.setCost(phr.getPlant().getPrice());
        phr.setStatus(PlantHireRequestStatus.applied);
        phr.setStart(Date.valueOf(map.getFirst("start")));
        phr.setEndr(Date.valueOf(map.getFirst("end")));
        service.modify(phr);
        model.addAttribute("message", "PlantHireRequest successfully modified");
        return "success";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/phr/cancel")
    public String cancelPlantHireRequest(@RequestBody MultiValueMap<String,String> map, HttpSession session, Model model){
        if (!session.getAttribute("role").equals(Role.admin) && !session.getAttribute("role").equals(Role.worksEngineer)){
            model.addAttribute("message", "Your role does not satisfy this request");
            return "error";
        }
        Long id = Long.parseLong(map.getFirst("phrId"));
        PlantHireRequest phr  = service.find(id);
        Date date = phr.getStart();
        GregorianCalendar c1 = new GregorianCalendar();
        GregorianCalendar c2 = new GregorianCalendar();
        c1.setTime(date);
        c2.setTime(Calendar.getInstance().getTime());
        int y1 = c1.get(Calendar.YEAR);
        int y2 = c2.get(Calendar.YEAR);
        System.out.println(y2 + "  asd" + y1);
        if (y2 == y1) {
            int d1 = c1.get(Calendar.DAY_OF_YEAR);
            int d2 = c2.get(Calendar.DAY_OF_YEAR);
            System.out.println(d1 + "fds  " + d2);
            int diff = d1 - d2;
            if (diff <= 1) {
                model.addAttribute("message", "It is too late to cancel this request");
                return "error";
            }
        }
//  System.out.println(d2-d1);

        if (phr.getStatus().equals(PlantHireRequestStatus.applied)){
            phr.setStatus(PlantHireRequestStatus.cancelled);
            service.create(phr);
        } else if (phr.getStatus().equals(PlantHireRequestStatus.sentToSupplier)){
            az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.CancelPurchaseOrderByIdE cpe
                    = new az.pkg.buildit.wsclient.PurchaseOrderWSServiceStub.CancelPurchaseOrderByIdE();
            cpe.setCancelPurchaseOrderById(new PurchaseOrderWSServiceStub.CancelPurchaseOrderById());
            cpe.getCancelPurchaseOrderById().setArg0(phr.getId());
            PurchaseOrderWSServiceStub s = null;
            try {
                s = new PurchaseOrderWSServiceStub();
                s.cancelPurchaseOrderById(cpe).getCancelPurchaseOrderByIdResponse().get_return();
            } catch (AxisFault axisFault) {
                axisFault.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("message", "Cancelled your request successfully");
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/phr/get")
    public String getPlantHireRequest(@RequestParam String phrId, Model model){
        PlantHireRequest phr = service.find(Long.parseLong(phrId));
        model.addAttribute("phr", phr);
        return "phrView";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/phr/all")
    public String getAllPlantHireRequests(Model model){
        List<PlantHireRequest> phrs = service.findAll();
        model.addAttribute("phrs", phrs);
        return "phrs";
    }
}
