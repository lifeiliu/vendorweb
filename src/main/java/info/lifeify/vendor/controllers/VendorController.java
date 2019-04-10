package info.lifeify.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.lifeify.vendor.entities.Vendor;
import info.lifeify.vendor.service.VendorService;

@Controller
public class VendorController {
	@Autowired 
	private VendorService service;
	
	@RequestMapping("/showCreate")
	public String createVendor() {
		return "createVendor";
	}
	@RequestMapping("/saveVendor")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		Vendor vendorSaved = service.saveVendor(vendor);
		String msg = "Vendor saved with id: " + vendorSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createVendor";
	}
	@RequestMapping("/showVendors")
	public String listVendors(ModelMap modelMap) {
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendor = new Vendor();
		vendor.setId(id);
		service.deleteVendor(vendor);
		List<Vendor> newVendors = service.getAllVendors();
		modelMap.addAttribute("vendors", newVendors);
		return "displayVendors";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendor = service.getVendorById(id);
		modelMap.addAttribute("vendor", vendor);
		return "editVendor";
	}
	@RequestMapping("/updateVendor")
	public String updateVendor(Vendor vendor, ModelMap modelMap) {
		service.updateVendor(vendor);
		List<Vendor> newVendors = service.getAllVendors();
		modelMap.addAttribute("vendors", newVendors);
		return "displayVendors";
	}
	
}
