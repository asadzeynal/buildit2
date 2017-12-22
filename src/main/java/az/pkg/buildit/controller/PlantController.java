package az.pkg.buildit.controller;

import az.pkg.buildit.entity.Plant;
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

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

@Controller
public class PlantController {

    @Autowired
    PlantService service;

    @RequestMapping(method = RequestMethod.POST, value = "/plant/create")
    public String createPlant(@RequestBody MultiValueMap<String,String> map, Model model) {
        Plant plant = new Plant();
        plant.setName(map.getFirst("name"));
        plant.setDescription(map.getFirst("desc"));
        plant.setPrice(Double.parseDouble(map.getFirst("price")));
        service.create(plant);
        model.addAttribute("name", map.getFirst("name"));
        return "list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/plant/all")
    public String getAllPlants(Model model){
        az.pkg.buildit.wsclient.PlantWSServiceStub.ListAllPlantsE cpe
                = new az.pkg.buildit.wsclient.PlantWSServiceStub.ListAllPlantsE();
        cpe.setListAllPlants(new PlantWSServiceStub.ListAllPlants());
        cpe.getListAllPlants();
        PlantWSServiceStub s = null;
        List<PlantWSServiceStub.Plant> l  = null;
        try {
            s = new PlantWSServiceStub();
            l = Arrays.asList(s.listAllPlants(cpe).getListAllPlantsResponse().get_return());
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        model.addAttribute("plants", l);
        return "plants";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/plant/get")
    public String getPlant(@RequestParam String id, Model model){
        az.pkg.buildit.wsclient.PlantWSServiceStub.GetPlantByIDE cpe
                = new az.pkg.buildit.wsclient.PlantWSServiceStub.GetPlantByIDE();
        cpe.setGetPlantByID(new PlantWSServiceStub.GetPlantByID());
        cpe.getGetPlantByID().setArg0(Long.parseLong(id));
        PlantWSServiceStub s = null;
        PlantWSServiceStub.Plant l  = null;
        try {
            s = new PlantWSServiceStub();
            l = s.getPlantByID(cpe).getGetPlantByIDResponse().get_return();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        model.addAttribute("plants", l);
        return "plants";
    }
}
