package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("Teste numero 1: seller findById: ");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("");
		
		System.out.println("Teste numero 2: seller findByDepartment: ");
		Department department = new Department(3, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("");

		
		System.out.println("Teste numero 3: seller findAll: ");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("");
		
		System.out.println("Teste numero 4: seller INSERT: ");
		Seller newSeller = new Seller("Greg", "greg@email.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted: " + newSeller.getId());
		System.out.println("");
		
		System.out.println("Teste numero 5: seller UPDATE: ");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Updated: " + newSeller.getId());
		System.out.println("");

	}

}
