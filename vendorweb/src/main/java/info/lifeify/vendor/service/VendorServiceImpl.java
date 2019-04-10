package info.lifeify.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.lifeify.vendor.entities.Vendor;
import info.lifeify.vendor.repos.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired 
	VendorRepository vendorRepo;
	
	@Override
	public Vendor saveVendor(Vendor vendor) {
		 return vendorRepo.save(vendor);
		
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return vendorRepo.save(vendor);
		
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		vendorRepo.delete(vendor);

	}

	@Override
	public Vendor getVendorById(int id) {
		return vendorRepo.findById(id).get();
	}

	@Override
	public List<Vendor> getAllVendors() {
		return  vendorRepo.findAll();
	}

	public VendorRepository getVendorRepo() {
		return vendorRepo;
	}

	public void setVendorRepo(VendorRepository vendorRepo) {
		this.vendorRepo = vendorRepo;
	}

}
