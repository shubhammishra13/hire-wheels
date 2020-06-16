package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class HireWheelsApplication implements CommandLineRunner {
	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	VehicleCategoryRepo vehicleCategoryRepo;

	@Autowired
	VehicleTypeRepository vehicleTypeRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	FuelTypeRepository fuelTypeRepository;

	@Autowired
	RequestStatusRepository requestStatusRepository;

	public static void main(String[] args) {
		SpringApplication.run(HireWheelsApplication.class, args);
	}

	@Override
	public void run(String... arg0) {
		UserRole adminUserRole = new UserRole();
		adminUserRole.setRoleId(1);
		adminUserRole.setRoleName("Admin");
		UserRole userRole = new UserRole();
		userRole.setRoleId(2);
		userRole.setRoleName("User");
		userRoleRepository.save(adminUserRole);
		userRoleRepository.save(userRole);
		Users adminUser = new Users();
		adminUser.setFirstName("Upgrad");
		adminUser.setLastName("Admim");
		adminUser.setEmail("upgrad@gmail.com");
		adminUser.setMobileNo(9898989890l);
		adminUser.setPassword("admin@123");
		adminUser.setUserRole(userRoleRepository.findByRoleId(1));
		userRepository.save(adminUser);
		List<Activity> listOfActivity = new ArrayList<>();
		Activity activity1 = new Activity();
		activity1.setActivityId(201);
		activity1.setActivityType("BOOKING");
		listOfActivity.add(activity1);
		Activity activity2 = new Activity();
		activity2.setActivityId(202);
		activity2.setActivityType("VEHICLE_REGISTER");
		listOfActivity.add(activity2);
		Activity activity3 = new Activity();
		activity3.setActivityId(203);
		activity3.setActivityType("CAR_OPT_IN");
		listOfActivity.add(activity3);
		Activity activity4 = new Activity();
		activity4.setActivityId(203);
		activity4.setActivityType("CAR_OPT_OUT");
		listOfActivity.add(activity4);
		activityRepository.saveAll(listOfActivity);
		List<VehicleCategory> vehicleCategoryList = new ArrayList<>();
		VehicleCategory vehicleCategory1 = new VehicleCategory();
		vehicleCategory1.setVehicleCategoryId(10);
		vehicleCategory1.setVehicleCategoryName("SUV");
		vehicleCategoryList.add(vehicleCategory1);
		VehicleCategory vehicleCategory2 = new VehicleCategory();
		vehicleCategory2.setVehicleCategoryId(11);
		vehicleCategory2.setVehicleCategoryName("SEDAN");
		vehicleCategoryList.add(vehicleCategory2);
		VehicleCategory vehicleCategory3 = new VehicleCategory();
		vehicleCategory3.setVehicleCategoryId(12);
		vehicleCategory3.setVehicleCategoryName("HATCHBACK");
		vehicleCategoryList.add(vehicleCategory3);
		VehicleCategory vehicleCategory4 = new VehicleCategory();
		vehicleCategory4.setVehicleCategoryId(13);
		vehicleCategory4.setVehicleCategoryName("CRUISER");
		vehicleCategoryList.add(vehicleCategory4);
		VehicleCategory vehicleCategory5 = new VehicleCategory();
		vehicleCategory5.setVehicleCategoryId(14);
		vehicleCategory5.setVehicleCategoryName("DIRT BIKE");
		vehicleCategoryList.add(vehicleCategory5);
		VehicleCategory vehicleCategory6 = new VehicleCategory();
		vehicleCategory6.setVehicleCategoryId(15);
		vehicleCategory6.setVehicleCategoryName("SPORTS BIKE");
		vehicleCategoryList.add(vehicleCategory6);
		vehicleCategoryRepo.saveAll(vehicleCategoryList);
		List<VehicleType> vehicleTypes = new ArrayList<>();
		VehicleType vehicleType1 = new VehicleType();
		vehicleType1.setVehicleTypeId(10001);
		vehicleType1.setVehicleTypeName("CAR");
		vehicleType1.setCostPerHour(300);
		vehicleType1.setVehicleCategory(vehicleCategoryRepo.findByVehicleCategoryId(10));
		vehicleTypes.add(vehicleType1);
		VehicleType vehicleType2 = new VehicleType();
		vehicleType2.setVehicleTypeId(10002);
		vehicleType2.setVehicleTypeName("CAR");
		vehicleType2.setCostPerHour(350);
		vehicleType2.setVehicleCategory(vehicleCategoryRepo.findByVehicleCategoryId(11));
		vehicleTypes.add(vehicleType2);
		VehicleType vehicleType3 = new VehicleType();
		vehicleType3.setVehicleTypeId(10003);
		vehicleType3.setVehicleTypeName("CAR");
		vehicleType3.setCostPerHour(250);
		vehicleType3.setVehicleCategory(vehicleCategoryRepo.findByVehicleCategoryId(12));
		vehicleTypes.add(vehicleType3);
		VehicleType vehicleType4 = new VehicleType();
		vehicleType4.setVehicleTypeId(10004);
		vehicleType4.setVehicleTypeName("BIKE");
		vehicleType4.setCostPerHour(200);
		vehicleType4.setVehicleCategory(vehicleCategoryRepo.findByVehicleCategoryId(13));
		vehicleTypes.add(vehicleType4);
		VehicleType vehicleType5 = new VehicleType();
		vehicleType5.setVehicleTypeId(10005);
		vehicleType5.setVehicleTypeName("BIKE");
		vehicleType5.setCostPerHour(150);
		vehicleType5.setVehicleCategory(vehicleCategoryRepo.findByVehicleCategoryId(14));
		vehicleTypes.add(vehicleType5);
		VehicleType vehicleType6 = new VehicleType();
		vehicleType6.setVehicleTypeId(10006);
		vehicleType6.setVehicleTypeName("BIKE");
		vehicleType6.setCostPerHour(150);
		vehicleType6.setVehicleCategory(vehicleCategoryRepo.findByVehicleCategoryId(15));
		vehicleTypes.add(vehicleType6);
		vehicleTypeRepository.saveAll(vehicleTypes);
		City city = new City();
		city.setCityId(1);
		city.setCityName("Mumbai");
		cityRepository.save(city);
		List<FuelType> fuelTypeList = new ArrayList<>();
		FuelType fuelType1 = new FuelType();
		fuelType1.setFuelType("Petrol");
		fuelType1.setFuelTypeId(1);
		fuelTypeList.add(fuelType1);
		FuelType fuelType2 = new FuelType();
		fuelType2.setFuelType("Diesel");
		fuelType2.setFuelTypeId(2);
		fuelTypeList.add(fuelType1);
		fuelTypeRepository.saveAll(fuelTypeList);
		List<RequestStatus> requestStatusList = new ArrayList<>();
		RequestStatus requestStatus1 = new RequestStatus();
		requestStatus1.setRequestStatusId(301);
		requestStatus1.setRequestStatusName("PENDING");
		requestStatusList.add(requestStatus1);
		RequestStatus requestStatus2 = new RequestStatus();
		requestStatus2.setRequestStatusId(302);
		requestStatus2.setRequestStatusName("APPROVED");
		requestStatusList.add(requestStatus2);
		RequestStatus requestStatus3 = new RequestStatus();
		requestStatus3.setRequestStatusId(303);
		requestStatus3.setRequestStatusName("REJECTED");
		requestStatusList.add(requestStatus3);
		RequestStatus requestStatus4 = new RequestStatus();
		requestStatus4.setRequestStatusId(304);
		requestStatus4.setRequestStatusName("BOOKED");
		requestStatusList.add(requestStatus4);
		requestStatusRepository.saveAll(requestStatusList);
	}

}
